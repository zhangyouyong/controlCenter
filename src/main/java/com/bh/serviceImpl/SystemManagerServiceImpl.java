package com.bh.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.SystemManagerDao;
import com.bh.service.SystemManagerService;
import com.shuyin.framework.mybatis.Page;
@Service(value="SystemManagerService")
public class SystemManagerServiceImpl implements SystemManagerService {
	@Autowired
	@Qualifier("SystemManagerDao")
	SystemManagerDao systemManagerDao;
	@Override
	public Map<String, Object> customerList(String loginName, Integer status,
			Page page) {
		
		return systemManagerDao.customerList(loginName, status, page);
	}
	@Override
	public void setUserStatus(Integer status,Long userId) {
		systemManagerDao.setUserStatus(status,userId);
	}
	@Override
	public void setUserCreditLimit(Long userId, Double quota) {
		systemManagerDao.setUserCreditLimit(userId, quota);
		
	}
	

}
