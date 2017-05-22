package com.bh.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bh.entity.BaseUser;
import com.bh.model.BaseUserModel;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.mybatis.Page;

public interface BaseUserDao{

	Long register(String name,String pwd) throws BHException; //注册

	BaseUserModel login(Map<String,Object> map) throws Exception; //登录
	
	void resetPassword(BaseUserModel user) throws BHException; //重置密码
	
	Integer userCountByName(String name);//获取用户数量
	
	Long insertBaseUser(BaseUser user); //插入用户信息
	
	Map<String, Object> subUserInfoByParentId(Integer parentId,String loginName,Page<BaseUser> pageResult);//根据父用户查询子用户信息
	
	Map<String,Object> userInfoById(Integer userId);//根据用户id获取用户信息
	
	void removeSubUser(Long parentUserId,Long subUserId);//删除子用户
	
	boolean checkSubUserName(String loginName);//判断用户名是否已存在
	
	Map<String,Object> accountUserInfoById(Long userId);
	
	void updateBaseUser(BaseUser user);//更新用户信息
	
	Integer isParentUser(Integer userId);//获取父用户id
	
}
