package com.bh.interceptor;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.bh.util.StringUtils;
import com.shuyin.framework3rd.redis.RedisClientTemplate;

public class TokenInterceptor implements HandlerInterceptor {
	@Autowired
	@Qualifier("redisClientTemplate")
	RedisClientTemplate redisClientTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token=request.getHeader("token");
		if(StringUtils.isNotBlank(token)&&redisClientTemplate.exists(token)){
			redisClientTemplate.expire(token,15*60);
			return true;
		}
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("code", 401);
		result.put("message", "token eorr");
		PrintWriter writer = response.getWriter();
		writer.write(JSONObject.toJSONString(result));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}
