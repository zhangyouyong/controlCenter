package com.bh.service;

import java.util.Map;

import com.shuyin.framework.mybatis.Page;

public interface SystemManagerService {
	Map<String,Object> customerList(final String loginName,final Integer status,final Page page);
	void setUserStatus(Integer status,Long userId);
	void setUserCreditLimit(Long userId,Double quota);
}
