package com.bh.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.GroupStrategyDao;
import com.bh.entity.GroupStrategy;
import com.bh.model.GroupStrategyModel;
import com.shuyin.framework.database.dao.BaseDao;

@Repository("GroupStrategyDao")
public class GroupStrategyDaoImpl extends BaseDao<GroupStrategy> implements GroupStrategyDao{

	@Override
	public void groupForStrategy(GroupStrategyModel groupStrategy) {
		getSqlSession().insert("GroupStrategy.strategyForGroup",groupStrategy);
	}

	@Override
	public void removeGroupStrategy(GroupStrategyModel groupStrategy) {
		getSqlSession().delete("GroupStrategy.removeGroupStrategy",groupStrategy);
	}

	@Override
	public Map<String, Object> groupStrategyList(Long groupId) {
		Map<String,Object> result=new HashMap<String, Object>();
		List unSelect=getSqlSession().selectList("GroupStrategy.groupUnSelectStrategy", groupId);	
		List selected=getSqlSession().selectList("GroupStrategy.groupSelectedStrategy",groupId);
		result.put("unSelect", unSelect);
		result.put("selected", selected);
		return result;
	}



}
