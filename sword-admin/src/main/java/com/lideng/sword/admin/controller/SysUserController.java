package com.lideng.sword.admin.controller;

import java.util.List;

import com.lideng.sword.admin.model.request.SysUserCreateDTO;
import com.lideng.sword.admin.model.request.SysUserUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.lideng.sword.admin.service.SysUserService;
import com.lideng.sword.core.http.HttpResult;

/**
 * 用户控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	////@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create(@RequestBody SysUserCreateDTO record) {
		return HttpResult.ok(sysUserService.create(record),"创建成功");
	}

	public static void main(String[] args) {
		System.out.println(123);
	}

	////@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysUserUpdateDTO record) {
		return HttpResult.ok(sysUserService.update(record),"更新成功");
	}

//	//@PreAuthorize("hasAuthority('sys:user:delete')")
//	@RequestMapping(value="/delete",method = RequestMethod.POST)
//	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestBody List<String> ids) {
//		return HttpResult.ok(sysUserService.delete(ids));
//	}


	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestParam String id) {
		sysUserService.deleteById(id);
		return HttpResult.ok(200,"删除成功");
	}
	
	//@PreAuthorize("hasAuthority('sys:user:view')")
    @RequestMapping(value="/findByName",method = RequestMethod.GET)
	public HttpResult findByUserName(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findByName(name));
	}
	
	//@PreAuthorize("hasAuthority('sys:user:view')")
    @RequestMapping(value="/findPermissions",method = RequestMethod.GET)
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findPermissions(name));
	}
	

    @RequestMapping(value="/findUserList",method = RequestMethod.GET)
	public HttpResult findUserList() {
		return HttpResult.ok(sysUserService.findUserList());
	}

}
