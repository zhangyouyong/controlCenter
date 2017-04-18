package com.bh.model;

import java.util.TreeMap;

import com.bh.entity.BaseMenu;


public class TreeMenu {
	
	private BaseMenu menu; // 菜单
	private TreeMap<String, TreeMenu> tmMap; // 菜单子节点
	//private int use;   // 是否已使用  0 未使用， 1，已使用
	
	public TreeMenu() {
		
	}
	
	public TreeMenu(BaseMenu menu, TreeMap<String, TreeMenu> tmMap) {
		this.menu = menu;
		this.tmMap = tmMap;
	}
	
	/*public TreeMenu(BaseMenu menu, TreeMap<Integer, TreeMenu> tmMap, int use) {
		this.menu = menu;
		this.tmMap = tmMap;
		this.use = use;
	}*/
	
	public BaseMenu getMenu() {
		return menu;
	}
	public void setMenu(BaseMenu menu) {
		this.menu = menu;
	}
	public TreeMap<String, TreeMenu> getTmMap() {
		return tmMap;
	}
	public void setTmMap(TreeMap<String, TreeMenu> tmMap) {
		this.tmMap = tmMap;
	}
	/*public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}*/
}
