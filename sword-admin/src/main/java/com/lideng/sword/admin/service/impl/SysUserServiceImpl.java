package com.lideng.sword.admin.service.impl;

import java.util.*;

import com.lideng.sword.admin.model.entity.DelStatus;
import com.lideng.sword.admin.model.entity.SysUser;
import com.lideng.sword.admin.model.request.SysUserCreateDTO;
import com.lideng.sword.admin.model.request.SysUserUpdateDTO;
import com.lideng.sword.admin.repository.UserRepository;
import com.lideng.sword.common.utils.PasswordUtils;
import com.lideng.sword.core.exception.SwordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lideng.sword.admin.model.entity.SysMenu;

import com.lideng.sword.admin.service.SysMenuService;
import com.lideng.sword.admin.service.SysUserService;

import static com.lideng.sword.admin.constant.SysConstants.ADMIN;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysUserServiceImpl  implements SysUserService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private SysMenuService sysMenuService;


	@Override
	public String create(SysUserCreateDTO record) {

		//传了部门ID和role ID，role ID没地方放
		SysUser sysUser=new SysUser();
		if(userRepository.findByName(record.getName()).isPresent()) {
			throw new SwordException("角色名已存在!");
		}
		BeanUtils.copyProperties(record,sysUser);
		String salt = PasswordUtils.getSalt();
		String password = PasswordUtils.encode(sysUser.getPassword(), salt);
		sysUser.setSalt(salt);
		sysUser.setPassword(password);
		sysUser.setDelFlag(DelStatus.NORMAL);
		sysUser.setVersion(0);
		sysUser.setDeptId(record.getDeptId());
		sysUser.setRoleId(record.getRoleId());
		return userRepository.save(sysUser).getId();
	}

	@Override
	public SysUser update(SysUserUpdateDTO record) {

		SysUser sysUser = userRepository.findById(record.getId()).orElseThrow(NoSuchElementException::new);

		if(ADMIN.getValue().equals(sysUser.getName())) {
			throw new SwordException("超级管理员不允许修改!");
		}
//		if(!record.getPassword().equals(sysUser.getPassword())) {
//			String password = PasswordUtils.encode(record.getPassword(), sysUser.getSalt());
//			record.setPassword(password);
//		}
		BeanUtils.copyProperties(record,sysUser);
		sysUser.setVersion(sysUser.getVersion()+1);

		return userRepository.save(sysUser);
	}

	@Override
	public int delete(List<String> ids) {

		//感觉不优雅，先放着吧
		for(String id:ids) {
			SysUser sysUser = userRepository.getOne(id);
			if(ADMIN.getValue().equalsIgnoreCase(sysUser.getName())) {
				throw new SwordException("超级管理员不允许删除!");
			}
		}
		//软删除 更新del_flag字段
		ids.forEach(id->userRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public List<SysUser> findUserList() {
		return userRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		SysUser sysUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
		sysUser.setDelFlag(DelStatus.DELETE);
		userRepository.save(sysUser);
	}

	@Override
	public SysUser findByName(String name) {
		return userRepository.findByName(name).orElseThrow(NoSuchElementException::new);
	}



	@Override
	public Set<String> findPermissions(String userName) {	
		Set<String> perms = new HashSet<>();
		List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
		for(SysMenu sysMenu:sysMenus) {
			if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
				perms.add(sysMenu.getPerms());
			}
		}
		return perms;
	}

//	@Override
//	public List<SysRole> findUserRoles(String userId) {
//		return userRepository.findById(userId).get().getSysRole();
//	}

}
