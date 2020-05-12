package com.lideng.sword.admin.service;

import java.util.List;

import com.lideng.sword.admin.entity.SysMenu;
import com.lideng.sword.admin.model.request.SysMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysMenuUpdateDTO;


import javax.servlet.http.HttpServletRequest;


/**
 * 菜单管理
 * @author lideng
 * @date July 30, 2019
 */
public interface SysMenuService  {

	/**
	 * 查询菜单树,用户ID和用户名为空则查询全部
	 * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
	 * @param
	 * @return
	 */
	List<SysMenu> findTree(String userName, int menuType);

	/**
	 * 根据用户名查找菜单列表
	 * @param userName
	 * @return
	 */
	List<SysMenu> findByUser(String userName);


	String create(SysMenuCreateDTO record);

	String update(SysMenuUpdateDTO record);

	int delete(List<String> ids);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	SysMenu findById(String id);


}
