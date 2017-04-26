package com.bh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bh.service.BaseUserService;
import com.bh.util.MessageUtil;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	@Qualifier("BaseUserService")
	private BaseUserService userService;
	
	@RequestMapping("register")
	@ResponseBody
	public Map<String,Object> register(final @RequestParam(value="name")String name,final @RequestParam(value="pwd") String pwd,final @RequestParam(value="sessionId") String sessionId,final @RequestParam(value="authCode") String authCode){
		OperateTemplate templete = new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",userService.register(name, pwd, sessionId, authCode)); 
			}
		};
		
		return templete.operate();
	}
	@RequestMapping("authCode")
	@ResponseBody
	public Map<String,Object> authCode(final @RequestParam(value="phone")String phone){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
			//	userService.phoneCodeFrequency(phone);
				map.put("sessionId",MessageUtil.sendMessageCode(phone, "3Hymah4_4CdaHMEUyH3RiF"));
			}
			
		};
		
		
		return  template.operate();
	}
	@RequestMapping("login")
	@ResponseBody
	public Map<String,Object> login(final @RequestParam(value="name")String name,final @RequestParam(value="pwd") String pwd){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				map.put("data",userService.login(name, pwd));
			}
		};
		return template.operate();
	}
	@RequestMapping("resetPassword")
	@ResponseBody
	
	public Map<String,Object> resetPassword(final @RequestParam(value="name")String name,final @RequestParam(value="pwd") String pwd){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userService.resetPassword(name, pwd);
			}
		};
		return template.operate();
	}
	@RequestMapping("resetPwdauthCode")
	@ResponseBody
	public Map<String,Object> resetPwdauthCode(final @RequestParam(value="phone")String phone){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				 //String authCode=userService.phoneAuthCode(phone, "_RESTPWD_MSGCODE", "【北航传媒】提醒你的验证码为：");
			//	userService.phoneCodeFrequency(phone);
				userService.checkUserNotNull(phone);
				String sessionId=MessageUtil.sendMessageCode(phone,"6rD9XkMcAjm8_XsdhgbZ_Z");
				map.put("sessionId", sessionId);
			}
		};
		return  template.operate();
	}
	@RequestMapping("verifyPhoneCode")
	@ResponseBody
	public Map<String,Object> verifyPhoneCode(final @RequestParam(value="sessionId")String sessionId,final @RequestParam(value="authCode")String authCode){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				boolean result=MessageUtil.sendMessageVerifyCode(sessionId, authCode);
				 map.put("result", result);
			}
		};
		return  template.operate();
	}
	/**
	 * 判断token是否存在
	 * @return
	 */
	@RequestMapping("checkToken")
	@ResponseBody
	public Map<String,Object> isNotExistToken(final String accessToken,final String userId
			
			){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				// TODO Auto-generated method stub
				userService.isNotExistToken(accessToken, userId);
			}
		};
		return template.operate();
	}
}
