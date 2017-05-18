package com.bh.dao;

import java.util.Map;

import com.bh.model.UserStrategyModel;


public interface UserStrategyDao{
	void strategyForUser(UserStrategyModel userStrategy);
	void removeUserStrategy(UserStrategyModel userStrategy);
	Map<String,Object> userStrategyList(Long userId);
}
