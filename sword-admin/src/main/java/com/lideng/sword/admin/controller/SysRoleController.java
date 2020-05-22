package com.lideng.sword.admin.controller;

import java.util.List;
import com.lideng.sword.admin.model.request.SysRoleCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.lideng.sword.admin.service.SysRoleService;
import com.lideng.sword.core.http.HttpResult;


import javax.servlet.http.HttpServletRequest;

/**
 * 角色控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	////@PreAuthorize("hasAuthority('sys:role:add') AND hasAuthority('sys:role:edit')")
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create(@RequestBody SysRoleCreateDTO record) {
		return HttpResult.ok(sysRoleService.create(record),"更新成功");
	}

	////@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysRoleUpdateDTO record ) {
		return HttpResult.ok(sysRoleService.update(record));
	}

	////@PreAuthorize("hasAuthority('sys:role:delete')")
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestParam String id) {
		sysRoleService.deleteById(id);
		return HttpResult.ok(200,"删除成功");
	}

	////@PreAuthorize("hasAuthority('sys:role:view')")
	@RequestMapping(value="/findAllRole",method = RequestMethod.GET)
	public HttpResult findAll() {
		return HttpResult.ok(sysRoleService.findAll(),"查询成功");
	}
	
	////@PreAuthorize("hasAuthority('sys:role:view')")
	@RequestMapping(value="/findRoleMenus",method = RequestMethod.GET)
	public HttpResult findRoleMenus(@RequestParam String roleId) {
		return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
	}


	////@PreAuthorize("hasAuthority('sys:role:view')")
	@RequestMapping(value="/saveRoleMenus",method = RequestMethod.POST)
	public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenuCreateDTO> records) {
		return HttpResult.ok(sysRoleService.saveRoleMenus(records),"保存成功");
	}
}
