package com.bh.dao;

import java.util.Map;

import com.bh.entity.UserAccountInfo;

public interface UserAccountInfoDao{
  Long addUserBankInfo(UserAccountInfo userAccountInfo);
  Map<String,Object> banckAccountInfo(Long userId);
  void updatebanckAccount(UserAccountInfo userAccountInfo);
}
