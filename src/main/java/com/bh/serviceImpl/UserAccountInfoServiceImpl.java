package com.bh.serviceImpl;

import java.util.Map;

import com.bh.dao.UserAccountInfoDao;
import com.bh.entity.UserAccountInfo;
import com.bh.service.UserAccountInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="UserAccountInfoService")
public class UserAccountInfoServiceImpl  implements UserAccountInfoService{
	@Autowired
	@Qualifier("UserAccountInfoDao")
	private UserAccountInfoDao userAccountInfoDao;

	@Override
	public void addUserBankInfo(UserAccountInfo userAccountInfo) {
		userAccountInfoDao.addUserBankInfo(userAccountInfo);
	}

	@Override
	public Map<String, Object> banckAccountInfo(Long userId) {
		return userAccountInfoDao.banckAccountInfo(userId);
	}

}
