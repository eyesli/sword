package com.lideng.sword.admin.service.impl;

import java.util.List;

import com.lideng.sword.admin.model.request.SysRoleCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysRoleUpdateDTO;
import com.lideng.sword.admin.repository.MenuRepository;
import com.lideng.sword.admin.repository.RoleRepository;
import com.lideng.sword.core.exception.SwordException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
	public SysRole create(SysRoleCreateDTO record) {

		SysRole sysRole =new SysRole();
		if(roleRepository.findByName(record.getName()).isPresent()) {
			throw new SwordException("角色名已存在!");
		}
		sysRole.setName(record.getName());
		sysRole.setDescription(record.getDesc());
		sysRole.setVersion(0);
		if (StringUtils.isBlank(record.getDepartmentId()))
		{
			sysRole.setDeptId(null);
		}
		sysRole.setDeptId(record.getDepartmentId());

		return roleRepository.save(sysRole);
	}

	@Override
	public SysRole update(SysRoleUpdateDTO record) {

		SysRole sysRole = roleRepository.getOne(record.getId());
		if(ADMIN.getValue().equals(sysRole.getName())) {
			throw new SwordException("超级管理员不允许修改!");
		}
		BeanUtils.copyProperties(record,sysRole);
		sysRole.setVersion(sysRole.getVersion()+1);
		return roleRepository.save(sysRole);
	}

	@Override
	public int delete(List<String> ids) {
		//todo  一场补货
		ids.forEach(id->roleRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public void deleteById(String id) {
		roleRepository.deleteById(id);
	}

	@Override
	public List<SysRole> findAll() {
		return roleRepository.findAll();
	}


	@Override
	public List<SysMenu> findRoleMenus(String roleId) {
		if(ADMIN.getValue().equalsIgnoreCase(roleRepository.getOne(roleId).getName())) {
			// 如果是超级管理员，返回全部
			return menuRepository.findAll();
		}
		return null;
	}


	@Override
	public int saveRoleMenus(List<SysRoleMenuCreateDTO> records) {

		String roleId = records.get(0).getRoleId();
		List<String> menuIdList = records.get(0).getMenuId();
		SysRole sysRole = roleRepository.getOne(roleId);
		if(ADMIN.getValue().equalsIgnoreCase(sysRole.getName())){
			throw new SwordException("超级管理员拥有所有菜单权限，不允许修改！");
		}

		//sysRole.setSysMenu(menuRepository.findAllById(menuIdList));
		roleRepository.save(sysRole);
		return menuIdList.size();
	}

}
