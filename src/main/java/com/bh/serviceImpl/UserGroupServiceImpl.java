package com.bh.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.UserGroupDao;
import com.bh.entity.UserGroup;
import com.bh.service.UserGroupService;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
import com.shuyin.framework.mybatis.Page;

@Service(value="UserGroupService")
public class UserGroupServiceImpl  implements UserGroupService{
	@Autowired
	@Qualifier("UserGroupDao")
	private UserGroupDao userGroupDao;

	@Override
	public Long addUserGruop(String groupName, String groupDescribe,Long userId)
			throws BHException {
		boolean flag=userGroupDao.checkGroupName(groupName, userId);//检测用户名是否重复
		 if(flag){
			 throw new BHException("组名已存在！",BHExceptionType.EXIST_GROUP);
		 }
	   UserGroup group=new UserGroup();
	   group.setGroupDescribe(groupDescribe);
	   group.setName(groupName);
	   group.setCreadTime(new Date());
	   group.setCreadBy(userId);
	   return userGroupDao.addUserGruop(group);
	}

	@Override
	public Map<String, Object> groupInfo(Long userId,String groupName, Page<UserGroup> page) throws BHException {
		if(userId==null){
			throw new BHException("userId不能为空!",BHExceptionType.MISS_FIELD);
		}
		return userGroupDao.groupInfo(userId,groupName,page);
	}

	@Override
	public void removeUserGroup(Long groupId) throws BHException {
		if(groupId==null){
			throw new BHException("groupId不能为空", BHExceptionType.MISS_FIELD);
		}
		userGroupDao.removeUserGroup(groupId);
	}

	@Override
	public Map<String, Object> groupDetail(Long groupId) throws BHException {
		return userGroupDao.groupDetail(groupId);
	}

}
