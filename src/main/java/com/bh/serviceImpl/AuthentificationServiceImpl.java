package com.bh.serviceImpl;



import com.bh.dao.AuthentificationDao;
import com.bh.entity.Authentification;
import com.bh.service.AuthentificationService;
import com.shuyin.framework.exception.BHException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="AuthentificationService")
public class AuthentificationServiceImpl  implements AuthentificationService{
	@Autowired
	@Qualifier("AuthentificationDao")
	private AuthentificationDao authentificationDao;

	@Override
	public void enterpriseCertification(
			Authentification authentification) throws BHException {
		authentificationDao.enterpriseCertification(authentification);
	}

}
