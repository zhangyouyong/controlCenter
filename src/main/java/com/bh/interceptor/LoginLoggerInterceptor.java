package com.bh.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bh.model.LoginLoggerModel;
import com.bh.service.LoggerService;
import com.bh.util.HttpUtil;

public class LoginLoggerInterceptor implements HandlerInterceptor{
	@Autowired
	@Qualifier("LoggerService")
	LoggerService loggerService;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex){
		Map<String,Object>  result=(Map<String,Object>)request.getAttribute("loginResult");
		boolean success=(boolean)result.get("success");
		String loginName=request.getParameter("name"); //用户名
		String ip=HttpUtil.getIpAddr(request);//ip
		String os=HttpUtil.getOsInfo(request);//系统
		String browser=HttpUtil.getdBrowserInfo(request);//浏览器
		LoginLoggerModel  logger=new LoginLoggerModel();
		logger.setBrowser(browser);
		logger.setIp(ip);
		logger.setLoginName(loginName);
		logger.setSystem(os);
		logger.setSuccess(success?1:2);
		loggerService.loginLogger(logger);
	}

}
