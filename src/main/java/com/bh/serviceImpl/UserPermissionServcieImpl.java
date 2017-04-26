package com.bh.serviceImpl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.BaseUserDao;
import com.bh.entity.BaseUser;
import com.bh.service.UserPermissionServcie;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
import com.shuyin.framework.mybatis.Page;
@Service(value="UserPermissionServcie")
public class UserPermissionServcieImpl implements UserPermissionServcie {
	@Autowired
	@Qualifier("BaseUserDao")
	BaseUserDao baseUserDao;
	@Override
	public Long insertSubUser(BaseUser user) throws BHException {
		String loginName=user.getLoginName();
		if(baseUserDao.checkSubUserName(loginName)){
			throw new BHException("登录用户名已经存在！",BHExceptionType.EXIST_USER);
		}
		if(user.getUserParent()==null){
			throw new BHException("父用户id不能为空!", BHExceptionType.COMMIT_NULL);
		}
		user.setUserSource(1);
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		return baseUserDao.insertBaseUser(user);
	}
	@Override
	public Map<String, Object> subUserInfoByParentId(Integer parentId,String loginName,Page<BaseUser> pageResult)
			throws BHException {
		// TODO Auto-generated method stub
		return baseUserDao.subUserInfoByParentId(parentId,loginName,pageResult);
	}
	@Override
	public void removeSubUser(Long parentUserId, Long subUserId)
			throws BHException {
		if(parentUserId==null){
			throw new BHException("parentUserId不能为空",BHExceptionType.COMMIT_NULL);
		}
		if(subUserId==null){
			throw new BHException("subUserId不能为空",BHExceptionType.COMMIT_NULL);
		}
		baseUserDao.removeSubUser(parentUserId, subUserId);
	}

}
  