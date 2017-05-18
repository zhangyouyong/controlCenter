package com.bh.serviceImpl;

import java.util.Map;

import com.bh.dao.GroupStrategyDao;
import com.bh.model.GroupStrategyModel;
import com.bh.service.GroupStrategyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="GroupStrategyService")
public class GroupStrategyServiceImpl  implements GroupStrategyService{
	@Autowired
	@Qualifier("GroupStrategyDao")
	private GroupStrategyDao groupStrategyDao;

	@Override
	public void groupForStrategy(GroupStrategyModel groupStrategy) {
		groupStrategyDao.groupForStrategy(groupStrategy);
	}

	@Override
	public void removeGroupStrategy(GroupStrategyModel groupStrategy) {
		groupStrategyDao.removeGroupStrategy(groupStrategy);
	}

	@Override
	public Map<String,Object> groupStrategyList(Long groupId) {
		return 	groupStrategyDao.groupStrategyList(groupId);
	}


}
