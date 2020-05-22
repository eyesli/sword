package com.lideng.sword.admin.controller;

import java.util.List;
import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.lideng.sword.admin.service.SysConfigService;
import com.lideng.sword.core.http.HttpResult;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统配置控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	//@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create(@RequestBody SysConfigSaveDTO record) {
		return HttpResult.ok(sysConfigService.create(record),"创建成功");
	}

	//@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public HttpResult update(@RequestBody SysConfigUpdateDTO record) {
		return HttpResult.ok(sysConfigService.update(record),"更新成功");
	}

	//@PreAuthorize("hasAuthority('sys:config:delete')")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public HttpResult delete(@ApiParam(value = "只用传ID")@RequestBody List<String> ids) {
		return HttpResult.ok(sysConfigService.delete(ids),"删除成功");
	}

	//@PreAuthorize("hasAuthority('sys:config:view')")
	@RequestMapping(value="/findByLabel",method = RequestMethod.GET)
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(sysConfigService.findByLabel(label));
	}

	@RequestMapping(value="/test",method = RequestMethod.GET)
	public HttpResult test(@RequestParam String label) {
		return HttpResult.ok(sysConfigService.test(label));
	}
}
