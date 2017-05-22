package com.bh.dao;

import java.util.Map;

import com.shuyin.framework.mybatis.Page;

public interface SystemManagerDao {
	Map<String, Object> customerList(String loginName, Integer status,Page page);
	void setUserStatus(Integer status,Long userId);
	void setUserCreditLimit(Long userId,Double quota);
}
