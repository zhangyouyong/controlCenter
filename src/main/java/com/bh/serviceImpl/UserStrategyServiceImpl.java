package com.bh.serviceImpl;

import com.bh.dao.UserStrategyDao;
import com.bh.model.UserStrategyModel;
import com.bh.service.UserStrategyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
