package com.bh.service;

import java.util.Map;

import com.bh.entity.BaseUser;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.mybatis.Page;

public interface UserPermissionServcie {
	Long insertSubUser(BaseUser user) throws BHException;
	
	Map<String,Object> subUserInfoByParentId(Integer parentId,String loginName,Page<BaseUser> pageResult) throws BHException;
	
	void removeSubUser(Long parentUserId,Long subUserId) throws BHException;
}
