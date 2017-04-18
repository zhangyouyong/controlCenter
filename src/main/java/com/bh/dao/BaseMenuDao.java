package com.bh.dao;

import java.util.Map;

import com.bh.model.TreeMenu;


public interface BaseMenuDao{
	Map<String, TreeMenu> getTreeMenu(Integer userId);
}
