package com.bh.serviceImpl;

import java.util.HashMap;
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
		Integer parent=baseUserDao.isParentUser(userId);
		Map<String,Object> parameter=new HashMap<String,Object>();
		Integer flag=0;
		if(parent>0){
			flag=1;
		}
		parameter.put("userId", userId);
		parameter.put("flag", flag);
		return baseMenuDao.getTreeMenu(parameter);
	}

}
