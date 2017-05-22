package com.bh.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.SystemManagerDao;
import com.shuyin.framework.mybatis.MyBatisDao;
import com.shuyin.framework.mybatis.Page;
@Repository("SystemManagerDao")
public class SystemManagerDaoImpl extends MyBatisDao implements SystemManagerDao {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> customerList(String loginName, Integer status,
			Page page) {
		Map<String,Object> parameter=new HashMap<String, Object>();
		Map<String,Object> result=new HashMap<String, Object>();
		parameter.put("loginName", loginName);
		parameter.put("status", status);
		Page selectPage = selectPage(page, "customerListByPage", parameter);
		result.put("total", selectPage.getTotalItems());
		result.put("rows", selectPage.getResult());
		return result;
	}

	@Override
	public void setUserStatus(Integer status,Long userId) {
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("status", status);
		parameter.put("userId", userId);
		getSqlSession().update("SystemManager.setUserStatus", parameter);
	}

	@Override
	public void setUserCreditLimit(Long userId, Double quota) {
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("userId", userId);
		parameter.put("quota", quota);
		getSqlSession().update("SystemManager.setUserCreditLimit", parameter);
	}
	
}
