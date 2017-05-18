package com.bh.serviceImpl;

import com.bh.dao.GroupStrategyDao;
import com.bh.service.GroupStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="GroupStrategyService")
public class GroupStrategyServiceImpl  implements GroupStrategyService{
	@Autowired
	@Qualifier("GroupStrategyDao")
	private GroupStrategyDao groupStrategyDao;

}
