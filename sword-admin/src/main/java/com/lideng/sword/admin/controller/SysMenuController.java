package com.lideng.sword.admin.controller;

import java.util.List;

import com.lideng.sword.admin.model.request.SysMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysMenuUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.lideng.sword.admin.service.SysMenuService;
import com.lideng.sword.core.http.HttpResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create(@RequestBody SysMenuCreateDTO record) {
		return HttpResult.ok(sysMenuService.create(record));
	}

	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysMenuUpdateDTO record) {
		return HttpResult.ok(sysMenuService.update(record));
	}

	@PreAuthorize("hasAuthority('sys:menu:delete')")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestBody List<String> ids) {
		return HttpResult.ok(sysMenuService.delete(ids));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@RequestMapping(value="/findNavTree",method = RequestMethod.GET)
	public HttpResult findNavTree(@RequestParam String userName) {
		return HttpResult.ok(sysMenuService.findTree(userName, 1));
	}
	
	@PreAuthorize("hasAuthority('sys:menu:view')")
	@RequestMapping(value="/findMenuTree",method = RequestMethod.GET)
	public HttpResult findMenuTree() {
		return HttpResult.ok(sysMenuService.findTree(null, 0));
	}
}
