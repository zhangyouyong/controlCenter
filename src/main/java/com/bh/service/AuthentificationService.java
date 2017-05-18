package com.bh.service;


import java.util.List;

import com.bh.entity.Authentification;
import com.shuyin.framework.exception.BHException;

public interface AuthentificationService {
	void enterpriseCertification(Authentification authentification) throws BHException;
	void applicationAccount(Long loginUserId,String phone,String pwd,Long application) throws BHException;//绑定用户信息
	List<Object> applicationAccountById(Long loginUserId) throws BHException;
}
