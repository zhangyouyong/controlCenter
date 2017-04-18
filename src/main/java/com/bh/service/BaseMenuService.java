package com.bh.service;

import java.util.Map;

import com.bh.model.TreeMenu;


public interface BaseMenuService {
	Map<String, TreeMenu> getTreeMenu(Integer userId);
}
