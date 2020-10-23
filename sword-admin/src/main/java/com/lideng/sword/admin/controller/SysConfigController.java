package com.lideng.sword.admin.controller;

import java.util.List;
import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;

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
//	@Autowired
//	private KafkaTemplate<String,Object> kafkaTemplate;

	@Autowired
	private SysConfigService sysConfigService;


	@RequestMapping(value="/create",method = RequestMethod.POST)
	public HttpResult create() {
		return HttpResult.ok(sysConfigService.test(),"创建成功");
	}

}
