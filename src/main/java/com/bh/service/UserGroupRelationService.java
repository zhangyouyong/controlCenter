package com.bh.service;

import java.util.Map;

import com.bh.model.UserGropRelationModel;
import com.bh.model.UserRelevanceGroupModel;
import com.shuyin.framework.exception.BHException;

public interface UserGroupRelationService {
	void userGroupRelation(UserGropRelationModel model) throws BHException; //用户组用户绑定
	void userRelevanceGroup(UserRelevanceGroupModel model);//用户关联多个组
	void userGroupRemove(UserGropRelationModel model) throws BHException;//用户组解除绑定
	Map<String,Object> userGroupRelationInfo(Long loginUserId,Long userGroupId) throws BHException;
	Map<String, Object> userRelevanceGroup(Long loginUserId, Long userId) throws BHException;
	void userGroupRemoveByUser(UserRelevanceGroupModel model) throws BHException;//用户移除多个组
}
