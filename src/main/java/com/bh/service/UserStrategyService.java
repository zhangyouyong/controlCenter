package com.bh.service;

import java.util.Map;

import com.bh.model.UserStrategyModel;
import com.shuyin.framework.exception.BHException;

public interface UserStrategyService {
	 void strategyForUser(UserStrategyModel strategy);
	 void removeUserStrategy(UserStrategyModel strategy);
	 Map<String,Object> userStrategyList(Long userId) throws BHException;
}
