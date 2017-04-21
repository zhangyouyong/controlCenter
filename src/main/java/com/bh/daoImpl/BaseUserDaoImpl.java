package com.bh.daoImpl;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.BaseUserDao;
import com.bh.entity.BaseUser;
import com.bh.model.BaseUserModel;
import com.bh.util.security.MD5;
import com.shuyin.framework.database.dao.BaseDao;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
import com.shuyin.framework.mybatis.Page;

@Repository("BaseUserDao")
public class BaseUserDaoImpl extends BaseDao<BaseUser> implements BaseUserDao{

	@Override
	public Long register(String name, String pwd) throws BHException {
		Integer count=(Integer)getSqlSession().selectOne("User.checkUserName",name);
		if(count>0){
			throw new BHException("此用户已存在!",BHExceptionType.EXIST_USER);
		}
		// TODO Auto-generated method stub
		BaseUser baseUser=new BaseUser();
		baseUser.setLoginName(name);//用户名
		baseUser.setPassword(pwd);//用户密码
		baseUser.setPhone(name);//用户手机号码
		baseUser.setUserSource(1);//用户来源 1终端用户 2平台用户 3合作方用户
		baseUser.setUserParent(0l);
		baseUser.setPassword(MD5.MD5Encode(pwd));
		baseUser.setCreateDate(new Date());
		baseUser.setUpdateDate((new Date()));
		baseUser.setStatus(1);//是否启用
		return  create(baseUser);
	}

	@Override
	public BaseUserModel login(Map<String, Object> map) throws Exception {
		BaseUserModel baserUser=(BaseUserModel)getSqlSession().selectOne("User.userLogin", map);
		if(baserUser==null){
			throw new BHException("用户名或密码不存在!",BHExceptionType.USER_NULL);
		}
		if(baserUser.getStatus()==0){
			throw new BHException("此用户已被禁用",BHExceptionType.USER_UNUSE);
		}
		return baserUser;
	}

	@Override
	public void resetPassword(BaseUserModel user) throws Exception {
		getSqlSession().update("User.resetPassword", user);
	}

	@Override
	public Integer userCountByName(String name) {
		Integer count=(Integer)getSqlSession().selectOne("User.checkUserName",name);
		return count;
	}

	@Override
	public Long insertBaerUser(BaseUser user) {
		return create(user);
	}

	@Override
	public Map<String, Object> subUserInfoByParentId(Integer parentId,String loginName,Page<BaseUser> pageResult) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		Map<String, Object> result=new HashMap<String,Object>();
		parameters.put("parentId", parentId);
		parameters.put("loginName", loginName);
		Page<BaseUser> selectPage = selectPage(pageResult, "querySubUserByPage", parameters);
		result.put("total", selectPage.getTotalItems());
		result.put("rows", selectPage.getResult());
		return result;
	}
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> userInfoById(Integer userId) {
		Map<String,Object> result=(Map<String,Object>)getSqlSession().selectOne("User.userInfoById", userId);
		return result;
	}

	@Override
	public void removeSubUser(Long parentUserId, Long subUserId) {
		Map<String,Object> parameters=new HashMap<String, Object>();
		parameters.put("parentUserId", parentUserId);
		parameters.put("subUserId", subUserId);
		getSqlSession().delete("User.removeSubUser", parameters);
	}

	@Override
	public boolean checkSubUserName(String loginName) {
		Integer count=(Integer)getSqlSession().selectOne("User.checkSubUserName", loginName);
		return count>0?true:false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> accountUserInfoById(Long userId) {
		Map<String,Object> result=(Map<String,Object>)getSqlSession().selectOne("User.accountUserInfoById", userId);
		return result;
	}



}
