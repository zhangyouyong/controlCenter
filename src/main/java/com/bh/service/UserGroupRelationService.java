package com.bh.service;

import java.util.Map;

import com.bh.model.UserGropRelationModel;
import com.shuyin.framework.exception.BHException;

public interface UserGroupRelationService {
	void userGroupRelation(UserGropRelationModel model) throws BHException; //用户组用户绑定
	void userGroupRemove(UserGropRelationModel model) throws BHException;//用户组解除绑定
	Map<String,Object> userGroupRelationInfo(Long loginUserId,Long userGroupId) throws BHException;
}
