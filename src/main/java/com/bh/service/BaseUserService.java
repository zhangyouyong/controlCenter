package com.bh.service;
import java.util.Map;

import com.bh.entity.BaseUser;
import com.shuyin.framework.exception.BHException;

public interface BaseUserService {
	String getPhoneCode(String phone) throws BHException;//验证码
	Map<String,Object> register(String name, String pwd, String sessionId,String autoCode)  throws BHException ; //用户注册
	Map<String,Object> login(String name,String pwd)  throws Exception ; //用户登录
	void resetPassword(String name,String pwd) throws Exception;//
	String phoneAuthCode(String phone,String redisKey,String content);
	boolean checkUserNotNull(String phone) throws BHException; //判断用户是否存在;
	void phoneCodeFrequency(String phone) throws BHException;//设置手机发送频率
	void isNotExistToken(String accessToken,String userId) throws BHException;//判断token是否存在
	 Map<String,Object> userInfoById(Integer userId) throws BHException; //根据用户id获取用户信息
	 Map<String,Object> accountUserInfoById(Long userId) throws BHException;//
	 Map<String,Object> userInfoByToken(String tokenCode) throws BHException;
	 void updateUser(BaseUser user) throws BHException;
}
