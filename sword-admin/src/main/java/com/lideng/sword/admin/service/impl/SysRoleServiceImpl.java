package com.lideng.sword.admin.service.impl;

import java.util.List;

import com.lideng.sword.admin.model.request.SysRoleCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleUpdateDTO;
import com.lideng.sword.admin.repository.MenuRepository;
import com.lideng.sword.admin.repository.RoleRepository;
import com.lideng.sword.core.exception.SwordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lideng.sword.admin.model.entity.SysMenu;
import com.lideng.sword.admin.model.entity.SysRole;
import com.lideng.sword.admin.service.SysRoleService;

import static com.lideng.sword.admin.constant.SysConstants.ADMIN;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysRoleServiceImpl  implements SysRoleService {


	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MenuRepository menuRepository;



	@Override
	public String create(SysRoleCreateDTO record) {

		SysRole sysRole =new SysRole();
		if(roleRepository.findByName(record.getName()).isPresent()) {
			throw new SwordException("角色名已存在!");
		}
		BeanUtils.copyProperties(record,sysRole);
		sysRole.setVersion(0);

		return roleRepository.save(sysRole).getId();
	}

	@Override
	public String update(SysRoleUpdateDTO record) {

		SysRole sysRole = roleRepository.getOne(record.getId());
		if(ADMIN.getValue().equals(sysRole.getName())) {
			throw new SwordException("超级管理员不允许修改!");
		}
		BeanUtils.copyProperties(record,sysRole);
		sysRole.setVersion(sysRole.getVersion()+1);
		return roleRepository.save(sysRole).getId();
	}

	@Override
	public int delete(List<String> ids) {
		ids.forEach(id->roleRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public List<SysRole> findAll() {
		List<SysRole> all = roleRepository.findAll();
		return all;
	}


	@Override
	public List<SysMenu> findRoleMenus(String roleId) {
		if(ADMIN.getValue().equalsIgnoreCase(roleRepository.getOne(roleId).getName())) {
			// 如果是超级管理员，返回全部
			return menuRepository.findAll();
		}
		return roleRepository.getOne(roleId).getSysMenu();
	}


	@Override
	public int saveRoleMenus(List<SysRoleMenuCreateDTO> records) {

		String roleId = records.get(0).getRoleId();
		List<String> menuIdList = records.get(0).getMenuId();
		SysRole sysRole = roleRepository.getOne(roleId);
		if(ADMIN.getValue().equalsIgnoreCase(sysRole.getName())){
			throw new SwordException("超级管理员拥有所有菜单权限，不允许修改！");
		}

		sysRole.setSysMenu(menuRepository.findAllById(menuIdList));
		roleRepository.save(sysRole);
		return menuIdList.size();
	}

}
