package com.bh.dao;

import java.util.Map;

import com.bh.model.UserGropRelationModel;

public interface UserGroupRelationDao{
	void userGroupRelation(UserGropRelationModel model);
	void userGroupRemove(UserGropRelationModel model);
	Map<String,Object> userGroupRelationInfo(Long loginUserId,Long userGroupId);
}
