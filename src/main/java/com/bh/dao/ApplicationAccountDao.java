package com.bh.dao;

import java.util.List;

import com.bh.entity.ApplicationAccount;

public interface ApplicationAccountDao{
	 void addApplicationAccount(ApplicationAccount applicationAccount);
	 List<Object> applicationAccount(Long loginUserId);
}
