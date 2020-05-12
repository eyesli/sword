package com.lideng.sword.admin.controller;

import java.util.List;

import com.lideng.sword.admin.model.request.SysDeptCreateDTO;
import com.lideng.sword.admin.model.request.SysDeptUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.lideng.sword.admin.service.SysDeptService;
import com.lideng.sword.core.http.HttpResult;
import javax.servlet.http.HttpServletRequest;

/**
 * 机构控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;
	
	@PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create(@RequestBody SysDeptCreateDTO record) {
		return HttpResult.ok(sysDeptService.create(record));
	}

	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysDeptUpdateDTO record) {
		return HttpResult.ok(sysDeptService.update(record));
	}

	@PreAuthorize("hasAuthority('sys:dept:delete')")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestBody List<String> ids) {
		return HttpResult.ok(sysDeptService.delete(ids));
	}

	@PreAuthorize("hasAuthority('sys:dept:view')")
	@RequestMapping(value="/findTree",method = RequestMethod.GET)
	public HttpResult findTree() {
		return HttpResult.ok(sysDeptService.findTree());
	}

}
