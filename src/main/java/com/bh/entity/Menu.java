package com.bh.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Famiover on 16/3/8.
 */

public class Menu implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    private String name;
    private String url;
    private List<Menu> menuList;







}
