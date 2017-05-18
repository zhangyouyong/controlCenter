package com.bh.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.UserStrategyDao;
import com.bh.model.UserStrategyModel;
import com.bh.service.UserStrategyService;
import com.shuyin.framework.exception.BHException;

@Service(value="UserStrategyService")
public class UserStrategyServiceImpl  implements UserStrategyService{
	@Autowired
	@Qualifier("UserStrategyDao")
	private UserStrategyDao userStrategyDao;

	@Override
	public void strategyForUser(UserStrategyModel strategy) {
		// TODO Auto-generated method stub
		userStrategyDao.strategyForUser(strategy);
	}

	@Override
	public void removeUserStrategy(UserStrategyModel strategy) {
		userStrategyDao.removeUserStrategy(strategy);
	}

	@Override
	public Map<String,Object> userStrategyList(Long userId) throws BHException {
		return userStrategyDao.userStrategyList(userId);
	}

}
