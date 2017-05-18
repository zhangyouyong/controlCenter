package com.bh.model;

import java.util.List;

public class UserStrategyModel {
	private Long userId ;
	private List<Long> menusId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getMenusId() {
		return menusId;
	}
	public void setMenusId(List<Long> menusId) {
		this.menusId = menusId;
	}
	
}
