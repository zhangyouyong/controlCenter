package com.bh.service;

import java.util.Map;

import com.bh.model.GroupStrategyModel;

public interface GroupStrategyService {
	void groupForStrategy(GroupStrategyModel groupStrategy);
	void removeGroupStrategy(GroupStrategyModel groupStrategy);
	Map<String,Object> groupStrategyList(Long groupId);
}
