package com.bh.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.BaseUserDao;
import com.bh.entity.BaseUser;
import com.bh.model.BaseUserModel;
import com.bh.service.BaseUserService;
import com.bh.util.DateUtil;
import com.bh.util.GetSqs;
import com.bh.util.MessageUtil;
import com.bh.util.StringUtils;
import com.bh.util.security.MD5;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
import com.shuyin.framework3rd.redis.RedisClientTemplate;
@Service(value="BaseUserService")
public class BaseUserServiceImpl implements BaseUserService {
	
	Logger logger=LoggerFactory.getLogger(BaseUserServiceImpl.class);
	@Autowired
	@Qualifier("redisClientTemplate")
	RedisClientTemplate redisClientTemplate;
	
	@Autowired
	@Qualifier("BaseUserDao")
	BaseUserDao baseUserDao;
	
	@Override
	public String getPhoneCode(String phone) throws BHException {
		String authCode=GetSqs.getAuthCode();
		//redisClientTemplate.setex(phone+"_msgCode",authCode,60*10);
		if("OK".equals(redisClientTemplate.setex(phone+"_LONG_MSGCODE",authCode,60*10))){
			try {
				MessageUtil.toMessage(phone,"【北航文化传媒】提醒你!你的登录验证码为:"+authCode+",此信息10分钟内有效!");
			} catch (Exception e) {	
				logger.error("短信发送异常");
				e.printStackTrace();
			}
		}
		return authCode;
	}
	@Override
	public String phoneAuthCode(String phone,String redisKey,String content){
		String authCode=GetSqs.getAuthCode();
		//redisClientTemplate.setex(phone+"_msgCode",authCode,60*10);
		if("OK".equals(redisClientTemplate.setex(redisKey,authCode,60*10))){
			try {
				MessageUtil.toMessage(phone,content+authCode+"此消息10分钟内有效!");
			} catch (Exception e) {	
				logger.error("短信发送异常!");
				e.printStackTrace();
			}
		}
		return authCode;
		
	}
	@Override
	public Map<String,Object> register(String name, String pwd, String sessionId,String autoCode) throws BHException {
//		boolean verify=MessageUtil.sendMessageVerifyCode(sessionId, autoCode);
//		if(!verify){
//			throw new BHException("短信验证码错误!", BHExceptionType.CODE_ERROR);
//		}
		Map<String,Object> result=new HashMap<String,Object>();
		BaseUserModel baseUser=new BaseUserModel();
		Long userId=baseUserDao.register(name, pwd);
		baseUser.setUserId(userId);
		baseUser.setLoginName(name);
		result.put("userId", userId);
		result.put("tokenCode", loginToken(baseUser));
		return result;
	}

	@Override
	public Map<String,Object> login(String name, String pwd) throws Exception {
		Map<String,Object> result=new HashMap<String,Object>();
		//判断用户名和密码是否正确
		Map<String,Object> propertys=new HashMap<String,Object>();
		propertys.put("loginName", name);
		propertys.put("password", MD5.MD5Encode(pwd));
		BaseUserModel baserUser = baseUserDao.login(propertys);
		result.put("userId", baserUser.getUserId());
		result.put("tokenCode", loginToken(baserUser));
		return result;
	}

	private String loginToken(BaseUserModel baserUser){
/*		String redisKey="Consoles_Login_User_Token_"+baserUser.getUserId();
		if(redisClientTemplate.exists(redisKey)){
			Map<String,String> redisResult=redisClientTemplate.hgetAll(redisKey);
			return redisResult.get("tokenCode");
		}*/
		Map<String,String> redisMap=new HashMap<String, String>();
		String userId=baserUser.getUserId().toString();
		//String userName=baserUser.getUserId().toString();
		redisMap.put("userId", userId);
		redisMap.put("userName", baserUser.getLoginName());
		String str="";
		for (int i = userId.length(); i < 9; i++) {
			str = str + "0";
		}
		String formatDate = DateUtil.formatDate(new Date(), "MMddHHmmss");
		String tokenCode = formatDate + str + userId+GetSqs.getContrastSeq();
	//	redisMap.put("tokenCode", tokenCode);
		String keyToke=MD5.MD5Encode(tokenCode);
		redisMap.put("tokenCode", keyToke);
		redisClientTemplate.hmset(keyToke,redisMap,60*15);
		return keyToke;
	}

	@Override
	public void resetPassword(String name, String pwd) throws Exception {
		BaseUserModel baseUser=new BaseUserModel();
		baseUser.setLoginName(name);
		baseUser.setPassWord(MD5.MD5Encode(pwd));
		baseUserDao.resetPassword(baseUser);
	}
	@Override
	public boolean checkUserNotNull(String phone) throws BHException {
		boolean flag=true;
		Integer count=baseUserDao.userCountByName(phone);
		if(count==0||count==null){
			flag=false;
			throw new BHException("此用户没被注册过!",BHExceptionType.USER_NULL);
		}
		return flag;
	}
	@Override
	public void phoneCodeFrequency(String phone) throws BHException{
		String key="Consoles_CodeFrequency_"+phone;
		if(redisClientTemplate.exists(key)){
			Map<String,String> redisResult=redisClientTemplate.hgetAll(key);
			int count =Integer.valueOf(redisResult.get("count"));
			if(count>10) {
				throw new BHException("短信一天发送频率不能超过十次！",BHExceptionType.CODE_FREQUENCY_ERROR);
			}
			redisClientTemplate.hset(key, "count",String.valueOf(++count));
					
		}else{
			Map<String,String> parameter=new HashMap<String,String>();
			parameter.put("count","1");
			
			parameter.put("lastUpdateTime", DateUtil.formatDate2String(new Date(),"yyyy-MM-dd hh:mm:ss"));
			redisClientTemplate.hmset(key,parameter,DateUtil.marginSecond());
		}
	}
	@Override
	public void isNotExistToken(String accessToken,String userId) throws BHException {
		if(StringUtils.isEmpty(accessToken)){
			throw new BHException("accessToken为必填字段!",BHExceptionType.MISS_FIELD);
		}
		if(StringUtils.isEmpty(userId)){
			throw new BHException("userId为必填字段!",BHExceptionType.MISS_FIELD);
		}
		
		boolean flag=redisClientTemplate.exists("Consoles_Login_User_Token_"+userId);
		if(!flag){
			throw new BHException("accessToken为必填字段!",BHExceptionType.AUTH_ERROR);
		}
	}
	@Override
	public Map<String,Object> userInfoById(Integer userId) throws BHException {
		// TODO Auto-generated method stub
		if(userId==null){
			throw new BHException("userId不能为空",BHExceptionType.MISS_FIELD);
		}
		return baseUserDao.userInfoById(userId);
	}
	@Override
	public Map<String, Object> accountUserInfoById(Long userId)
			throws BHException {
		if(userId==null){
			throw new BHException("userId不能为空",BHExceptionType.MISS_FIELD);
		}
		return baseUserDao.accountUserInfoById(userId);
	}
	@Override
	public Map<String, Object> userInfoByToken(String tokenCode)
			throws BHException {
		boolean exists= redisClientTemplate.exists(tokenCode);
		if(!exists){
			throw new BHException("tokenCode失效或者不存在!",BHExceptionType.TOKEN_EXIST);
		}
		Map<String,String> reidsObject= redisClientTemplate.hgetAll(tokenCode);
		Integer userId=Integer.parseInt(reidsObject.get("userId"));
		
		return baseUserDao.userInfoById(userId);
	}
	@Override
	public void updateUser(BaseUser user) throws BHException {
		baseUserDao.updateBaseUser(user);
	}
	
	
}
