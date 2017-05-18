package com.bh.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bh.dao.ApplicationAccountDao;
import com.bh.entity.ApplicationAccount;
import com.shuyin.framework.database.dao.BaseDao;

@Repository("ApplicationAccountDao")
public class ApplicationAccountDaoImpl extends BaseDao<ApplicationAccount> implements ApplicationAccountDao{

	@Override
	public void addApplicationAccount(ApplicationAccount applicationAccount) {
		create(applicationAccount);
	}

	@Override
	public List<Object> applicationAccount(Long loginUserId) {
		List<Object> list=getSqlSession().selectList("ApplicationAccount.applicatonAccountBind", loginUserId);
		return list;
	}



}
