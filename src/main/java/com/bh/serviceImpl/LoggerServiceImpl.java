package com.bh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.LoggerDao;
import com.bh.model.LoginLoggerModel;
import com.bh.service.LoggerService;
@Service(value="LoggerService")
public class LoggerServiceImpl implements LoggerService {
	@Autowired
	@Qualifier("LoggerDao")
	LoggerDao loggerDao;

	@Override
	public void loginLogger(LoginLoggerModel logger) {
		loggerDao.loginLogger(logger);
	}
}
