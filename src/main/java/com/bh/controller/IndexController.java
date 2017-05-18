package com.bh.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bh.service.BaseMenuService;
import com.shuyin.framework.controller.CommonController;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;

@Controller
@RequestMapping
public class IndexController extends CommonController {

	@Autowired
	@Qualifier("BaseMenuService")
	private BaseMenuService menuService;

	/**
	 * 加载头部菜单
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/showMenu",produces ="text/html;charset=UTF-8")
	@ResponseBody
	public Object showMenu(final Integer userId) throws Exception {
		OperateTemplate templete = new HttpTemplate() {
			protected void doSomething() throws Exception {
				json.put("list", menuService.getTreeMenu(userId));
			}
		};
		return templete.operateJson().toString();
	}
}
