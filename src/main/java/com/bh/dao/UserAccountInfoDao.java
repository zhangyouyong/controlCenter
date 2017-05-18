package com.bh.dao;

import java.util.Map;

import com.bh.entity.UserAccountInfo;

public interface UserAccountInfoDao{
  void addUserBankInfo(UserAccountInfo userAccountInfo);
  Map<String,Object> banckAccountInfo(Long userId);
}
