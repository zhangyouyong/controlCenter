package com.bh.service;

import java.util.Map;

import com.bh.entity.UserGroup;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.mybatis.Page;

public interface UserGroupService {
	Long addUserGruop(String groupName,String groupDescribe,Long userId) throws BHException;
	Map<String, Object> groupInfo(Long userId,String groupName, Page<UserGroup> page) throws BHException;
}
