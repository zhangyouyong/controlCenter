package com.bh.service;


import com.bh.entity.Authentification;
import com.shuyin.framework.exception.BHException;

public interface AuthentificationService {
	void enterpriseCertification(Authentification authentification) throws BHException;
}
