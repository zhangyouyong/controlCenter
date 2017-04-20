package com.bh.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.UserGroupRelationDao;
import com.bh.model.UserGropRelationModel;
import com.bh.model.UserRelevanceGroupModel;
import com.bh.service.UserGroupRelationService;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;

@Service(value="UserGroupRelationService")
public class UserGroupRelationServiceImpl  implements UserGroupRelationService{
	@Autowired
	@Qualifier("UserGroupRelationDao")
	private UserGroupRelationDao userGroupRelationDao;

	@Override
	public void userGroupRelation(UserGropRelationModel userGroupRelation)
			throws BHException {
		List<Long> userIds=userGroupRelation.getUserIds();
		if(userIds==null||userIds.size()==0){
			return ;
		}
		 userGroupRelationDao.userGroupRelation(userGroupRelation);
	}

	@Override
	public void userGroupRemove(UserGropRelationModel model) throws BHException {
		List<Long> userIds=model.getUserIds();
		if(userIds==null||userIds.size()==0){
			return ;
		}
		// TODO Auto-generated method stub
		userGroupRelationDao.userGroupRemove(model);
	}

	@Override
	public Map<String, Object> userGroupRelationInfo(Long loginUserId,
			Long userGroupId) throws BHException {
		// TODO Auto-generated method stub
		return userGroupRelationDao.userGroupRelationInfo(loginUserId, userGroupId);
	}

	@Override
	public Map<String, Object> userRelevanceGroup(Long loginUserId, Long userId)
			throws BHException {
		// TODO Auto-generated method stub
		return userGroupRelationDao.userRelevanceGroup(loginUserId, userId);
	}

	@Override
	public void userRelevanceGroup(UserRelevanceGroupModel model) {

		userGroupRelationDao.userRelevanceGroup(model);
	}

	@Override
	public void userGroupRemoveByUser(UserRelevanceGroupModel model) throws BHException{
		List<Long> groupIds=model.getGroupIds();
		Long userId=model.getUserId();
		if(groupIds==null){
			throw new BHException("groupIds不能为空!", BHExceptionType.COMMIT_NULL);
		}
		if(userId==null){
			throw new BHException("userId不能为空",BHExceptionType.COMMIT_NULL);
		}
		userGroupRelationDao.userGroupRemoveByUser(model);
	}
	

}
