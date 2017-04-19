package com.bh.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.UserGroupDao;
import com.bh.entity.UserGroup;
import com.shuyin.framework.database.dao.BaseDao;
import com.shuyin.framework.mybatis.Page;

@Repository("UserGroupDao")
public class UserGroupDaoImpl extends BaseDao<UserGroup> implements UserGroupDao{

	@Override
	public Long addUserGruop(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return create(userGroup);
	}

	@Override
	public Map<String, Object> groupInfo(Long userId,String groupName, Page<UserGroup> page) {
		// TODO Auto-generated method stub
		Map<String,Object> parameters=new HashMap<String,Object>();
		Map<String, Object> result=new HashMap<String,Object>();
		parameters.put("userId", userId);
		parameters.put("groupName", groupName);
		Page<UserGroup> selectPage = selectPage(page, "userGroupInfoByPage", parameters);
		result.put("total", selectPage.getTotalItems());
		result.put("rows", selectPage.getResult());
		return result;
	}

	@Override
	public void removeUserGroup(Long groupId) {
		getSqlSession().delete("UserGroup.removeUserGroup", groupId);
	}

	@Override
	public boolean checkGroupName(String groupName, Long loginUserId) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("groupName", groupName);
		parameters.put("loginUserId", loginUserId);
		Integer count=(Integer)getSqlSession().selectOne("UserGroup.checkGroupName", parameters);
		return count>0?true:false;
	}

}
