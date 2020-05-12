package com.lideng.sword.admin.service;

import java.util.List;

import com.lideng.sword.admin.model.entity.SysConfig;
import com.lideng.sword.admin.model.entity.User;

import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;


/**
 * 系统配置管理
 * @author lideng
 * @date July 30, 2019
 */
public interface SysConfigService  {

	/**
	 * 根据名称查询
	 * @param label
	 * @return
	 */
	List<SysConfig> findByLabel(String label);

	/**
	 * 创建操作
	 * @param record
	 * @param
	 * @return
	 */
	String create(SysConfigSaveDTO record);


	/**
	 * 保存操作
	 * @param record
	 * @param
	 * @return
	 */
	String update(SysConfigUpdateDTO record);


	/**
	 * 批量删除
	 * @param ids
	 */
	int delete(List<String> ids);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	SysConfig findById(String id);

	List<User> test (String label);

}
