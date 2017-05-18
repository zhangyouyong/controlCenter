package com.bh.serviceImpl;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.ApplicationAccountDao;
import com.bh.dao.AuthentificationDao;
import com.bh.entity.ApplicationAccount;
import com.bh.entity.Authentification;
import com.bh.model.ApplicationAccountModel;
import com.bh.service.AuthentificationService;
import com.bh.util.FlightUtil;
import com.bh.util.HttpUtil;
import com.mongodb.util.JSON;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;

@Service(value="AuthentificationService")
public class AuthentificationServiceImpl  implements AuthentificationService{
	@Autowired
	@Qualifier("AuthentificationDao")
	private AuthentificationDao authentificationDao;
	@Autowired
	@Qualifier("ApplicationAccountDao")
	private ApplicationAccountDao applicationAccountDao;
	@Override
	public void enterpriseCertification(
			Authentification authentification) throws BHException {
		authentification.setAuthState(2);//创建即审核中
		authentificationDao.enterpriseCertification(authentification);
	}

	@Override
	public void applicationAccount(Long loginUserId, String phone,
			String pwd, Long application) throws BHException{
		ApplicationAccountModel applcationAccount=new ApplicationAccountModel();
		applcationAccount.setBindingUserId(loginUserId);
		applcationAccount.setMobile(phone);
		applcationAccount.setPwd(pwd);
			String resultJson = null;
			try {
				Map<String,String> header=new HashMap<String,String>();
				header.put("Content-Type", "application/json");
				String url=FlightUtil.getProperties("applicationaccount.properties", "url");
				resultJson = HttpUtil.sendPostRequest(url,header,applcationAccount.toString(),"utf-8");
			} catch (Exception e) {
				 throw new BHException("通信异常", BHExceptionType.SEND_ERROR);
			}
			 Map<String,Object> result=(Map<String,Object>)JSON.parse(resultJson);
			 if(result.containsKey("code")&&(Integer)(result.get("code"))==200){
				  ApplicationAccount account=new ApplicationAccount();
				  account.setApplicationId(application);
				  account.setUserId(loginUserId);
				  account.setCrearedtime(new Date());
				  account.setCreatedby(loginUserId);
				  account.setUpdatedtime(new Date());
				  account.setUpdatedby(loginUserId);
				  applicationAccountDao.addApplicationAccount(account);
			 }else{
				 throw new BHException(result.get("message").toString(), result.get("code").toString());
			 }
		}

	@Override
	public List<Object> applicationAccountById(Long loginUserId) throws BHException {
		return applicationAccountDao.applicationAccount(loginUserId);
	} 

}
