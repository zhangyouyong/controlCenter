package com.bh.dao;

import java.util.Map;

import com.bh.model.UserGropRelationModel;
import com.bh.model.UserRelevanceGroupModel;

public interface UserGroupRelationDao{
	void userGroupRelation(UserGropRelationModel model);
	void userRelevanceGroup(UserRelevanceGroupModel model);
	void userGroupRemove(UserGropRelationModel model);
	Map<String,Object> userGroupRelationInfo(Long loginUserId,Long userGroupId);
	Map<String,Object> userRelevanceGroup(Long loginUserId,Long userId);
}
