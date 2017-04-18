package com.bh.dao;

import java.util.List;
import java.util.Map;

import com.bh.entity.UserGroup;
import com.shuyin.framework.mybatis.Page;

public interface UserGroupDao{
	Long addUserGruop(UserGroup userGroup);
	Map<String, Object> groupInfo(Long userId,String groupName, Page<UserGroup> page);
}
