package com.bh.daoImpl;

import com.bh.entity.UserAccountInfo;
import com.bh.dao.UserAccountInfoDao;
import com.shuyin.framework.database.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("UserAccountInfoDao")
public class UserAccountInfoDaoImpl extends BaseDao<UserAccountInfo> implements UserAccountInfoDao{

	@Override
	public void addUserBankInfo(UserAccountInfo userAccountInfo) {
		create(userAccountInfo);
	}



}
