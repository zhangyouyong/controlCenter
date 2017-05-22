package com.bh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bh.service.SystemManagerService;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;
import com.shuyin.framework.mybatis.Page;
@Controller
@RequestMapping("SystemManager")
public class SystemManagerController {
	@Autowired
	@Qualifier("SystemManagerService")
	SystemManagerService systemManagerService;
	
	@RequestMapping("customerList")
	@ResponseBody
	public Map<String,Object> customerList(final String loginName,final Integer status,final Integer page,final Integer rows){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				Page pageResult = new Page();
				pageResult.setPageNo(page);
				pageResult.setPageSize(rows);
				map.put("data",systemManagerService.customerList(loginName, status, pageResult));
			}
		};
		return template.operate();
	}
	@RequestMapping("setUserStatus")
	@ResponseBody
	public Map<String,Object> setUserStatus(final Long userId,final Integer status){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				systemManagerService.setUserStatus(status,userId);
			}
		};
		return template.operate();
	}
	@RequestMapping("setUserCreditLimit")
	@ResponseBody
	public Map<String,Object> setUserCreditLimit(final Long userId,final Double quota){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				systemManagerService.setUserCreditLimit(userId, quota);
			}	
		};
		return template.operate();
	}
}
