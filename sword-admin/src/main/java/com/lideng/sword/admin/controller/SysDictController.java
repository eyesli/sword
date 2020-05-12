package com.lideng.sword.admin.controller;

import java.util.List;
import com.lideng.sword.admin.model.request.SysDictCreateDTO;
import com.lideng.sword.admin.model.request.SysDictUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.lideng.sword.admin.service.SysDictService;
import com.lideng.sword.core.http.HttpResult;
import javax.servlet.http.HttpServletRequest;

/**
 * 字典控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;
	
	@PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
	@PostMapping(value="/create")
	public HttpResult create(@RequestBody SysDictCreateDTO record) {
		return HttpResult.ok(sysDictService.create(record));
	}

	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysDictUpdateDTO record, HttpServletRequest request) {
		return HttpResult.ok(sysDictService.update(record));
	}

	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestBody List<String> ids) {
		return HttpResult.ok(sysDictService.delete(ids));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping(value="/findByLabel")
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(sysDictService.findByLabel(label));
	}
}
