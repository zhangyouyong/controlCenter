package com.bh.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.BaseMenuDao;
import com.bh.dao.BaseUserDao;
import com.bh.model.TreeMenu;
import com.bh.service.BaseMenuService;

@Service(value="BaseMenuService")
public class BaseMenuServiceImpl  implements BaseMenuService{
	@Autowired
	@Qualifier("BaseMenuDao")
	private BaseMenuDao baseMenuDao;
	@Autowired
	@Qualifier("BaseUserDao")
	private BaseUserDao baseUserDao;

	@Override
	public Map<String, TreeMenu> getTreeMenu(Integer userId) {
		// TODO Auto-generated method stub
		return baseMenuDao.getTreeMenu(userId);
	}

}
