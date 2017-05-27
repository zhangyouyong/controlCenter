package com.bh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bh.entity.BaseUser;
import com.bh.entity.UserGroup;
import com.bh.model.GroupStrategyModel;
import com.bh.model.UserGropRelationModel;
import com.bh.model.UserRelevanceGroupModel;
import com.bh.model.UserStrategyModel;
import com.bh.service.BaseUserService;
import com.bh.service.GroupStrategyService;
import com.bh.service.UserGroupRelationService;
import com.bh.service.UserGroupService;
import com.bh.service.UserPermissionServcie;
import com.bh.service.UserStrategyService;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;
import com.shuyin.framework.mybatis.Page;

@Controller
@RequestMapping("UsePermission")
public class UserPermissionController {
	@Autowired
	@Qualifier("UserGroupService")
	UserGroupService userGroupService;
	
	@Autowired
	@Qualifier("UserPermissionServcie")
	UserPermissionServcie userPermissionServcie;
	
	@Autowired
	@Qualifier("UserGroupRelationService")
	UserGroupRelationService userGroupRelationService;
	
	@Autowired
	@Qualifier("BaseUserService")
	BaseUserService baseUserService;
	
	@Autowired
	@Qualifier("UserStrategyService")
	UserStrategyService userStrategyService;
	
	@Autowired
	@Qualifier("GroupStrategyService")
	GroupStrategyService groupStrategyService;
	/**
	 * 添加组
	 * @param groupName
	 * @param groupDescribe
	 * @return
	 */
	@RequestMapping("addUserGroup")
	@ResponseBody
	public Map<String, Object> addUserGroup(final String groupName,final  String groupDescribe,final Long loginId){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				// TODO Auto-generated method stub
				map.put("groupId",userGroupService.addUserGruop(groupName, groupDescribe,loginId));
			}
		};
		return template.operate();
	}
	/**
	 * 组详情
	 * @param groupId
	 * @return
	 */
	@RequestMapping("groupDatail")
	@ResponseBody
	public Map<String,Object> groupDetail(final Long groupId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",userGroupService.groupDetail(groupId));
			}
		};
		return template.operate();
	}
	@RequestMapping("editGroup")
	@ResponseBody
	public Map<String,Object> editGroup(final UserGroup group){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userGroupService.editGroup(group);
			}
		};
		return template.operate();
	}
	/**
	 * 删除用户组
	 * @param loginUserId
	 * 
	 * 
	 * 
	 * @param groupId
	 * @return
	 */
	@RequestMapping("removeUserGroup")
	@ResponseBody
	public Map<String,Object> removeUserGroup(final Long groupId ){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userGroupService.removeUserGroup(groupId);
			}
		};
		return template.operate();
	}
	/**
	 * 根据用户id查询用户组列表
	 * @param userId
	 * @return
	 */
	@RequestMapping("userGroupList")
	@ResponseBody
	public Map<String,Object> userGroupList(final Long loginId,final String groupName,final Integer page,final Integer rows){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				Page<UserGroup> pageResult = new Page<UserGroup>();
				pageResult.setPageNo(page);
				pageResult.setPageSize(rows);
				map.put("data",userGroupService.groupInfo(loginId,groupName,pageResult)); 
			}
		};
		return template.operate();
	}
	/**
	 * 添加子用户信息
	 * @return
	 */
	@RequestMapping("insertSubUser")
	@ResponseBody
	public Map<String,Object> insertSubUser(final BaseUser user ){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				map.put("userId",userPermissionServcie.insertSubUser(user));
			}
		};
		return template.operate();
	}
	/**
	 * 删除子用户
	 * @param parentUserId
	 * @param subUserId
	 * @return
	 */
	@RequestMapping("removeSubUser")
	@ResponseBody
	public Map<String,Object> removeSubUser(final Long parentUserId,final Long subUserId){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				userPermissionServcie.removeSubUser(parentUserId, subUserId);
			}
		};
		return template.operate();
	}
	/**
	 * 根据父用户ID查询子用户列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("subUserInfo")
	@ResponseBody
	public Map<String,Object> subUserInfoParentId(final Integer loginId,final String loginName,final Integer page,final Integer rows){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				Page<BaseUser> pageResult = new Page<BaseUser>();
				pageResult.setPageNo(page);
				pageResult.setPageSize(rows);
				map.put("data",userPermissionServcie.subUserInfoByParentId(loginId,loginName,pageResult));
			}
		};
		return template.operate();
	}
	/**
	 * 组关联用户
	 * @return
	 */
	@RequestMapping("userGroupRelation")
	@ResponseBody
	public Map<String,Object> userGroupRelation(@RequestBody final UserGropRelationModel model){
		OperateTemplate template=new HttpTemplate(){

			@Override
			protected void doSomething() throws Exception {
				userGroupRelationService.userGroupRelation(model); 
			}
			
		};
		return template.operate();
	}
	/**
	 * 解除用户组关联
	 * @param model
	 * @return
	 */
	@RequestMapping(value="userGroupRemove")
	@ResponseBody
	public Map<String,Object> userGroupRemove(@RequestBody final UserGropRelationModel model){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userGroupRelationService.userGroupRemove(model);
			}
		};
		return template.operate();
	} 
	/**
	 * 查看组绑定用户详情
	 * @return
	 */
	@RequestMapping(value="userGroupRelationInfo")
	@ResponseBody
	public Map<String,Object> userGroupRelationInfo(final Long loginUserId,final Long userGroupId){
		OperateTemplate template=new HttpTemplate(){

			@Override
			protected void doSomething() throws Exception {
				map.put("data",userGroupRelationService.userGroupRelationInfo(loginUserId, userGroupId));
			}
			 
		};
		return template.operate();
	}
	/**
	 * 用户添加组列表
	 * @param loginUserId
	 * @param userId
	 * @return
	 */
	@RequestMapping("userRelevanceGroupInfo")
	@ResponseBody
	public Map<String,Object> userRelevanceGroupInfo(final Long loginUserId,final Long userId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data", userGroupRelationService.userRelevanceGroup(loginUserId, userId));
			}
		};
		return template.operate();
	}
	/**
	 * 用户添加多个组
	 * @param model
	 * @return
	 */
	@RequestMapping("userRelevanceGroup")
	@ResponseBody
	public Map<String,Object> userRelevanceGroup(@RequestBody final UserRelevanceGroupModel model){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userGroupRelationService.userRelevanceGroup(model);
			}
		};
		return template.operate();
	}
	/**
	 * 把组剔除当前用户
	 * @param model
	 * @return
	 */
	@RequestMapping("userGroupRemoveByUser")
	@ResponseBody
	public Map<String,Object> userGroupRemoveByUser(@RequestBody final UserRelevanceGroupModel model){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				userGroupRelationService.userGroupRemoveByUser(model);
			}
		};
		return template.operate();
	}
	/**
	 * 用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("userInfo")
	@ResponseBody
	public Map<String,Object> userInfo(final Long userId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",baseUserService.accountUserInfoById(userId));
			}
		};
		return template.operate();
	}
	/**
	 * 策略关联到用户
	 * @param strategys
	 * @return
	 */
	@RequestMapping("strategyForUser")
	@ResponseBody
	public Map<String,Object> strategyForUser(@RequestBody final UserStrategyModel strategys){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userStrategyService.strategyForUser(strategys);
			}
		};
		return template.operate();
	}
	/**
	 * 删除用户策略
	 * @param strategys
	 * @return
	 */
	@RequestMapping("removeUserStrategy")
	@ResponseBody
	public Map<String,Object> removeUserStrategy(@RequestBody final UserStrategyModel strategys){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				userStrategyService.removeUserStrategy(strategys);
			}
		};
		return template.operate();
	}
	/**
	 * 用户策略绑定列表
	 * @return
	 */
	@RequestMapping("userStrategyList")
	@ResponseBody
	public Map<String,Object> userStrategyList(@RequestParam(value="userId")final Long userId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",userStrategyService.userStrategyList(userId));
			}
		};
		return template.operate();
	}
	/**
	 * 策略关联到用户组
	 * @param groupStrategy
	 * @return
	 */
	@RequestMapping("strategyForGroup")
	@ResponseBody
	public Map<String,Object> strategyForGroup(@RequestBody final GroupStrategyModel groupStrategy){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				groupStrategyService.groupForStrategy(groupStrategy);
			}
		};
		return template.operate();
	}
	/**
	 * 删除用户组策略关联
	 * @param groupStrategy
	 * @return
	 */
	@RequestMapping("removeStrategyGroup")
	@ResponseBody
	public Map<String,Object> removeStrategyGroup(@RequestBody final GroupStrategyModel groupStrategy){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				groupStrategyService.removeGroupStrategy(groupStrategy);
			}
		};
		return template.operate();
	}
	/**
	 * 组策略绑定列表
	 * @return
	 */
	@RequestMapping("groupStrategyList")
	@ResponseBody
	public Map<String,Object> groupStrategyList(@RequestParam(value="groupId")final Long groupId){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",groupStrategyService.groupStrategyList(groupId));
			}
		};
		return template.operate();
	}
}


