package com.bh.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bh.entity.UserStrategy;
import com.bh.model.UserStrategyModel;
import com.bh.dao.UserStrategyDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository("UserStrategyDao")
public class UserStrategyDaoImpl extends BaseDao<UserStrategy> implements UserStrategyDao{

	@Override
	public void strategyForUser(UserStrategyModel userStrategy) {
		getSqlSession().insert("UserStrategy.strategyForUser",userStrategy);
	}

	@Override
	public void removeUserStrategy(UserStrategyModel userStrategy) {
		getSqlSession().delete("UserStrategy.removeUserStrategy",userStrategy);
	}

	@Override
	public Map<String,Object> userStrategyList(Long userId) {
		Map<String,Object> result=new HashMap<String, Object>();
		List<Object> unSelect=getSqlSession().selectList("UserStrategy.userUnSelectStrategy", userId);
		List<Object> selected=getSqlSession().selectList("UserStrategy.userSelectedStrategy", userId);
		result.put("unSelect", unSelect);
		result.put("selected", selected);
		return result;
	}


}
