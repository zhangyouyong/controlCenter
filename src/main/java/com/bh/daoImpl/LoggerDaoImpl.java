package com.bh.daoImpl;

import org.springframework.stereotype.Repository;

import com.bh.dao.LoggerDao;
import com.bh.model.LoginLoggerModel;
import com.shuyin.framework.mybatis.MyBatisDao;
@Repository("LoggerDao")
public class LoggerDaoImpl extends MyBatisDao implements LoggerDao  {

	@Override
	public void loginLogger(LoginLoggerModel logger) {
		getSqlSession().insert("logger.insert_login_logger",logger);
	}

}
