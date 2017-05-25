package com.bh.daoImpl;

import java.util.Map;

import com.bh.entity.UserAccountInfo;
import com.bh.dao.UserAccountInfoDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

@Repository("UserAccountInfoDao")
public class UserAccountInfoDaoImpl extends BaseDao<UserAccountInfo> implements UserAccountInfoDao{
	
	@Override
	public Long addUserBankInfo(UserAccountInfo userAccountInfo) {
		return create(userAccountInfo);
	}

	@Override
	public Map<String, Object> banckAccountInfo(Long userId) {
		Map<String,Object> result=(Map<String,Object>)getSqlSession().selectOne("User.accountInfoByUserId", userId);
		return result;
	}

	@Override
	public void updatebanckAccount(UserAccountInfo userAccountInfo) {
		modify(userAccountInfo);
	}



}
