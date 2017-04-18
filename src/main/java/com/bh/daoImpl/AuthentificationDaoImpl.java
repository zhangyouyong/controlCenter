package com.bh.daoImpl;

import com.bh.entity.Authentification;
import com.bh.dao.AuthentificationDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository("AuthentificationDao")
public class AuthentificationDaoImpl extends BaseDao<Authentification> implements AuthentificationDao{

	@Override
	public void enterpriseCertification(Authentification authentification) {
		create(authentification);
	}



}
