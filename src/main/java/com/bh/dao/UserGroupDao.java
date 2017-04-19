package com.bh.dao;

import java.util.Map;

import com.bh.entity.UserGroup;
import com.shuyin.framework.mybatis.Page;

public interface UserGroupDao{
	Long addUserGruop(UserGroup userGroup);
	Map<String, Object> groupInfo(Long userId,String groupName, Page<UserGroup> page);
	void removeUserGroup(Long groupId);//删除用户组
	boolean checkGroupName(String groupName,Long loginUserId);//检测组是否重名
}
