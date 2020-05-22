package com.lideng.sword.admin.service;

import java.util.List;

import com.lideng.sword.admin.model.entity.SysMenu;
import com.lideng.sword.admin.model.entity.SysRole;
import com.lideng.sword.admin.model.request.SysRoleCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleUpdateDTO;


/**
 * 角色管理
 * @author lideng
 * @date July 30, 2019
 */
public interface SysRoleService {

	/**
	 * 查询全部
	 * @return
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<SysMenu> findRoleMenus(String roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<SysRoleMenuCreateDTO> records);

	SysRole create(SysRoleCreateDTO record);

	SysRole update(SysRoleUpdateDTO record);

	int delete(List<String> ids);

	void deleteById(String id);

}
