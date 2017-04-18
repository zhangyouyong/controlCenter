package com.bh.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bh.entity.UserGroupRelation;
import com.bh.model.UserGropRelationModel;
import com.bh.dao.UserGroupRelationDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository("UserGroupRelationDao")
public class UserGroupRelationDaoImpl extends BaseDao<UserGroupRelation> implements UserGroupRelationDao{

	@Override
	public void userGroupRelation(UserGropRelationModel model) {
		getSqlSession().insert("userGroupRelation.insertUserGroup",model);
	}

	@Override
	public void userGroupRemove(UserGropRelationModel model) {
		// TODO Auto-generated method stub
		getSqlSession().delete("userGroupRelation.userGroupRemove",model);
	}

	@Override
	public Map<String, Object> userGroupRelationInfo(Long loginUserId,
			Long userGroupId) {
		Map<String,Object> parameters=new HashMap<String, Object>();
		Map<String,Object> result=new HashMap<String,Object>();
		// TODO Auto-generated method stub
		parameters.put("loginUserId", loginUserId);
		parameters.put("userGroupId", userGroupId);
		List<Object> selects=getSqlSession().selectList("userGroupRelation.groupSelectUser", userGroupId);
		List<Object> noSelects=getSqlSession().selectList("userGroupRelation.groupNoSelectUser", parameters);
		result.put("selects", selects);
		result.put("noSelects",noSelects);
		return result;
	}

	

}
