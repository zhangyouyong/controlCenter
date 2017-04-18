package com.bh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.shuyin.framework.mybatis.Page;
/**
 * 
 * @author TangZhiQiang
 * @date 2013-5-14
 */
public class ParameterUtils {
	/**
	 * 
	 * @param session
	 * @param request
	 * @param model
	 * @param page
	 * @param objects
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List ParameterVoluation(HttpSession session, ServletRequest request,
			ModelMap model, Page page, Object... objects) {
		if(page != null) {
			String curPage = request.getParameter("pageNum");
			String pageSize = request.getParameter("numPerPage");
			if (StringUtils.isNotBlank(curPage)) {
				page.setPageNo(Integer.parseInt(curPage));
			}
			if (StringUtils.isNotBlank(pageSize)) {
				page.setPageSize(Integer.parseInt(pageSize));
			} else {
				page.setPageSize(10);
			}
		}
		List list = new ArrayList(2);
		Map<String, Object> map = ParameterHandling(request, objects);
		list.add(0, page);
		list.add(1, map);
		return list;
	}
	
	/**
	 * 处理参数，以防重复编写request.getParameter。传递ServletRequest对象和Object数组
	 * @param request
	 * @param objects
	 * @return
	 */
	public static Map<String, Object> ParameterHandling(ServletRequest request, Object... objects) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < objects.length; i++) {
				map.put(objects[i].toString(),
						request.getParameter(objects[i].toString()));
		}
		return map;
	}
}
