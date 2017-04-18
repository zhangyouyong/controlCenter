package com.bh.serviceImpl;

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
		// TODO Auto-generated method stub
		if(user.getUserParent()==null){
			throw new BHException("父用户id不能为空!", BHExceptionType.COMMIT_NULL);
		}
		user.setUserSource(1);
		return baseUserDao.insertBaerUser(user);
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
  