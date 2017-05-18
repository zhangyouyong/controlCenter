package com.bh.service;

import java.util.Map;

import com.bh.entity.UserAccountInfo;

public interface UserAccountInfoService {
	void addUserBankInfo(UserAccountInfo userAccountInfo);
	Map<String,Object>  banckAccountInfo(Long userId);
}
