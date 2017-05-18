package com.bh.dao;

import java.util.Map;

import com.bh.model.GroupStrategyModel;

public interface GroupStrategyDao{
	void groupForStrategy(GroupStrategyModel groupStrategy);
	void removeGroupStrategy(GroupStrategyModel groupStrategy);
	Map<String,Object> groupStrategyList(Long groupId);
}	
