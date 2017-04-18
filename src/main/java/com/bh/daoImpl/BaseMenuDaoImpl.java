package com.bh.daoImpl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.bh.dao.BaseMenuDao;
import com.bh.entity.BaseMenu;
import com.bh.model.TreeMenu;
import com.shuyin.framework.database.dao.BaseDao;

@Repository("BaseMenuDao")
public class BaseMenuDaoImpl extends BaseDao<BaseMenu> implements BaseMenuDao{
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, TreeMenu> getTreeMenu(Integer userId) {
		List<BaseMenu> list = getSqlSession().selectList("menu.getList", userId);
		Map<String,TreeMenu> trMap = new TreeMap<String, TreeMenu>();
		for (BaseMenu menu : list) {
			String[] tree = menu.getNode().split("-");
			int i = 1;
			TreeMenu tm = null;
			while ( i < tree.length ) {
				Map<String, TreeMenu> m = (tm != null) ? tm.getTmMap() : trMap;
				if (m == null) {
					tm.setTmMap(new TreeMap<String, TreeMenu>());
				}
				tm = m.get(tree[i]);
				if ( tm == null ) {
					tm = new TreeMenu(menu, new TreeMap<String, TreeMenu>());
					m.put(tree[i], tm);
				}
				i++;
			}
		}
		return trMap;
	}


}
