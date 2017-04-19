package com.bh.model;

import java.util.List;

public class UserRelevanceGroupModel {
	private List<Long> groupIds;
	private  Long userId;
	public List<Long> getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(List<Long> groupIds) {
		this.groupIds = groupIds;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
