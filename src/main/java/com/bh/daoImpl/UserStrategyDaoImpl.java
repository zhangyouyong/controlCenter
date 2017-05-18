package com.bh.daoImpl;

import com.bh.entity.UserStrategy;
import com.bh.model.UserStrategyModel;
import com.bh.dao.UserStrategyDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository("UserStrategyDao")
public class UserStrategyDaoImpl extends BaseDao<UserStrategy> implements UserStrategyDao{

	@Override
	public void strategyForUser(UserStrategyModel userStrategy) {
		// TODO Auto-generated method stub
		getSqlSession().insert("UserStrategy.strategyForUser",userStrategy);
	}


}
