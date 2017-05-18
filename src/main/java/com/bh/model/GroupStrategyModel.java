package com.bh.model;

import java.util.List;

public class GroupStrategyModel {
	private Long groupId;
	private List<Long> menusId;
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public List<Long> getMenusId() {
		return menusId;
	}
	public void setMenusId(List<Long> menusId) {
		this.menusId = menusId;
	}
	
}
