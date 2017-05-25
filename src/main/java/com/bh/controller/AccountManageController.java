package com.bh.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bh.entity.Authentification;
import com.bh.entity.BaseUser;
import com.bh.entity.SysFile;
import com.bh.entity.UserAccountInfo;
import com.bh.model.UserAccountInfoModel;
import com.bh.service.AuthentificationService;
import com.bh.service.BaseUserService;
import com.bh.service.FileManageService;
import com.bh.service.SysDictionaryService;
import com.bh.service.SysFileService;
import com.bh.service.UserAccountInfoService;
import com.bh.util.StringUtils;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
@Controller
@RequestMapping("Account")
public class AccountManageController {
	
	
	@Autowired
	@Qualifier("AuthentificationService")
	AuthentificationService authentificationService;
	
	@Autowired
	@Qualifier("SysDictionaryService")
	SysDictionaryService sysDictionaryService;
	
	@Autowired
	@Qualifier("BaseUserService")
	BaseUserService baseUserService;
	
	@Autowired
	@Qualifier("UserAccountInfoService") 
	UserAccountInfoService userAccountInfoService;

	
//	@RequestMapping("test")
//	public String index(final HttpServletRequest request){
//		return "index";
//	}
	public static void main(String[] args) {
		String fileName="QQ图片20170322104029";
		System.out.println(fileName.substring(0,fileName.lastIndexOf(".")));
	}
	/**
	 * 企业认证
	 * @param authentification
	 * @return
	 */
	@RequestMapping("enterpriseCertification")
	@ResponseBody
	public Map<String,Object> enterpriseCertification(final Authentification authentification){
		OperateTemplate template=new OperateTemplate() {
			@Override
			protected void doSomething() throws Exception {
				// TODO Auto-generated method stub
				authentificationService.enterpriseCertification(authentification);
			}
		};
		return template.operate();
	}
	
//	@RequestMapping("userInfo/{userId}")
//	@ResponseBody
//	public Map<String,Object> userInfoById(@PathVariable("userId")final  Integer userId ){
//		OperateTemplate template=new HttpTemplate() {
//			
//			@Override
//			protected void doSomething() throws Exception {
//				map.put("data",baseUserService.userInfoById(userId));
//			}
//		};
//		return template.operate();
//	}
	@RequestMapping("userInfo")
	@ResponseBody
	public Map<String,Object> userInfoByToken(@RequestParam(value="tokenCode")final  String tokenCode ){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				map.put("data",baseUserService.userInfoByToken(tokenCode));
			}
		};
		return template.operate();
	}
	/**
	 * 获取模板信息
	 * @param code
	 * @return
	 */
	@RequestMapping("industryInfo")
	@ResponseBody
	public Map<String,Object> industryInfo(final String code){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data", sysDictionaryService.dictionaryInfo(code));
			}
		};
		return template.operate();
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(final BaseUser user){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				baseUserService.updateUser(user);
			}
		};
		return template.operate();
	}
	/**
	 * 应用账号关联
	 * @return
	 */
	@RequestMapping("applicationAccount")
	@ResponseBody
	public Map<String,Object> applicationAccount(@RequestParam("loginUserId")final Long loginUserId,@RequestParam("loginName")final String loginName,@RequestParam("pwd")final String pwd,@RequestParam("application")final Long application){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				authentificationService.applicationAccount(loginUserId, loginName, pwd, application);
			}
		};
		return template.operate();
	} 
	/**
	 * 根据用户id查询引用账号绑定信息
	 * @param loginUserId
	 * @return
	 */
	@RequestMapping("applicationAccountBind")
	@ResponseBody
	public Map<String,Object> applicationAccountById(@RequestParam(""
			+ ""
			+ "")final Long loginUserId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",authentificationService.applicationAccountById(loginUserId));
			}
		};
		return template.operate();
	}
	/**
	 * 添加开户行信息
	 * @param accountInfo
	 * @return
	 */
	@RequestMapping(value="addBankAccountInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addUserBankInfo(final UserAccountInfo accountInfo){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				Map<String,Object> result=new HashMap<String,Object>();
				result.put("accountId", userAccountInfoService.addUserBankInfo(accountInfo));
				map.put("data", result);
			}
		};
		return template.operate();
	}
	/**
	 * 查看开户行信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="bankAccountInfo" ,method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object>  bankAccountInfo(final Long userId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",userAccountInfoService.banckAccountInfo(userId));
			}
		};
		return template.operate();
	}
	/**修改开户行信息**/
	@RequestMapping(value="updatebankAccount",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  updatebankAccount(final UserAccountInfoModel model){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				UserAccountInfo userAccountInfo=new UserAccountInfo();
				userAccountInfo.setId(model.getAccountId());
				userAccountInfo.setBankAccountName(model.getBankAccountName());
				userAccountInfo.setBankAddress(model.getBankAddress());
				userAccountInfo.setDepositBank(model.getDepositBank());
				userAccountInfoService.updateAccount(userAccountInfo);
			}
		};
		return template.operate();
	}
	
}
