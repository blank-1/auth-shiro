package com.rz51.permission.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rz51.common.controller.BaseController;
import com.rz51.core.mybatis.page.Pagination;
import com.rz51.permission.enti.URoleExt;
import com.rz51.permission.enti.UserRoleAllocationExt;
import com.rz51.permission.service.PermissionService;
import com.rz51.user.service.UUserService;
/**
 * 
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.rz51.com<p>
 * 博客地址：http://www.sojson.com/blog/ <p>
 * <p>
 * 
 * 用户角色分配
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@rz51.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("role")
public class UserRoleAllocationController extends BaseController {
	@Autowired
	UUserService userService;
	@Autowired
	PermissionService permissionService;
	/**
	 * 用户角色权限分配
	 * @param modelMap
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@RequestMapping(value="allocation")
	public ModelAndView allocation(ModelMap modelMap,Integer pageNo,String findContent){
		modelMap.put("findContent", findContent);
		Pagination<UserRoleAllocationExt> boPage = userService.findUserAndRole(modelMap,pageNo,pageSize);
		modelMap.put("page", boPage);
		return new ModelAndView("role/allocation");
	}
	
	/**
	 * 根据用户ID查询权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectRoleByUserId")
	@ResponseBody
	public List<URoleExt> selectRoleByUserId(Long id){
		List<URoleExt> bos = userService.selectRoleByUserId(id);
		return bos;
	}
	/**
	 * 操作用户的角色
	 * @param userId 	用户ID
	 * @param ids		角色ID，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="addRole2User")
	@ResponseBody
	public Map<String,Object> addRole2User(Long userId,String ids){
		return userService.addRole2User(userId,ids);
	}
	/**
	 * 根据用户id清空角色。
	 * @param userIds	用户ID ，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="clearRoleByUserIds")
	@ResponseBody
	public Map<String,Object> clearRoleByUserIds(String userIds){
		return userService.deleteRoleByUserIds(userIds);
	}
}