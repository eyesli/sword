package com.lideng.sword.admin.service;

import java.util.List;


import com.lideng.sword.admin.model.entity.SysDept;
import com.lideng.sword.admin.model.request.SysDeptCreateDTO;
import com.lideng.sword.admin.model.request.SysDeptUpdateDTO;


/**
 * 机构管理
 * @author lideng
 * @date July 30, 2019
 */
public interface SysDeptService  {

	/**
	 * 查询机构树
	 * @param
	 * @return
	 */
	List<SysDept> findTree();

	/**
	 * 保存操作
	 * @param record
	 * @return
	 */
	String create(SysDeptCreateDTO record);

	/**
	 * 保存操作
	 * @param record
	 * @param
	 * @return
	 */
	String update(SysDeptUpdateDTO record);




	int delete(List<String> ids);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	SysDept findById(String id);


}
