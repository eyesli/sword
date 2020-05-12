package com.lideng.sword.admin.service.impl;
import java.util.Date;

import java.util.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lideng.sword.admin.model.request.SysUserCreateDTO;
import com.lideng.sword.admin.model.request.SysUserUpdateDTO;
import com.lideng.sword.common.utils.PasswordUtils;
import com.lideng.sword.common.utils.IdWorker;
import com.lideng.sword.core.exception.SwordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lideng.sword.admin.dao.SysUserMapper;
import com.lideng.sword.admin.dao.SysUserRoleMapper;
import com.lideng.sword.admin.entity.SysMenu;
import com.lideng.sword.admin.model.entity.SysUser;
import com.lideng.sword.admin.model.entity.SysUserRole;
import com.lideng.sword.admin.service.SysMenuService;
import com.lideng.sword.admin.service.SysUserService;
import javax.servlet.http.HttpServletRequest;

import static com.lideng.sword.admin.constant.SysConstants.ADMIN;
import static com.lideng.sword.admin.constant.SysConstants.USERNAME;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysUserServiceImpl  implements SysUserService {

    @Autowired
    private IdWorker idWorker;

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;


	@Override
	public String create(SysUserCreateDTO record, HttpServletRequest request) {

		//传了部门ID和role ID，role ID没地方放
		SysUser sysUser=new SysUser();
		if(sysUserMapper.findByName(record.getName())!=null) {
			throw new SwordException("角色名已存在!");
		}
		BeanUtils.copyProperties(record,sysUser);
		String salt = PasswordUtils.getSalt();
		String password = PasswordUtils.encode(sysUser.getPassword(), salt);
		sysUser.setSalt(salt);
		sysUser.setPassword(password);
		sysUser.setId(idWorker.nextId() + "");
		sysUser.setCreateBy((String) request.getSession().getAttribute(USERNAME.getValue()));
		sysUser.setCreateTime(new Date());
		sysUser.setDelFlag(false);
		sysUser.setVersion(0);
		sysUserMapper.insert(sysUser);

		//插入角色ID
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(sysUser.getId());
		sysUserRole.setRoleId(record.getRoleId());
		sysUserRole.setId(idWorker.nextId() + "");
		sysUserRole.setCreateBy((String) request.getSession().getAttribute(USERNAME.getValue()));
		sysUserRole.setCreateTime(new Date());
		sysUserRoleMapper.insert(sysUserRole);

		//返回ID
		return sysUser.getId();
	}

	@Override
	public String update(SysUserUpdateDTO record, HttpServletRequest request) {

		SysUser sysUser = sysUserMapper.selectByPrimaryKey(record.getId());

		if(ADMIN.getValue().equals(sysUser.getName())) {
			throw new SwordException("超级管理员不允许修改!");
		}
		if(!record.getPassword().equals(sysUser.getPassword())) {
			String password = PasswordUtils.encode(record.getPassword(), sysUser.getSalt());
			record.setPassword(password);
		}
		BeanUtils.copyProperties(record,sysUser);
		sysUser.setLastUpdateBy((String) request.getSession().getAttribute(USERNAME.getValue()));
		sysUser.setLastUpdateTime(new Date());
		sysUser.setVersion(sysUser.getVersion()+1);
		log.info(sysUser.toString());
		sysUserMapper.updateByPrimaryKey(sysUser);
		return sysUser.getId();
	}

	@Override
	public int delete(List<String> ids) {

		//感觉不优雅，先放着吧
		for(String id:ids) {
			SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
			if(sysUser != null && ADMIN.getValue().equalsIgnoreCase(sysUser.getName())) {
				throw new SwordException("超级管理员不允许删除!");
			}
		}
		//软删除 更新del_flag字段
		ids.forEach(id->sysUserMapper.deleteByPrimaryKey(id));
		return ids.size();
	}

	@Override
	public SysUser findByName(String name) {
		return sysUserMapper.findByName(name);
	}

	@Override
	public PageInfo<SysUser> findUserPage(Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<SysUser> userList = sysUserMapper.findAll();
		return new PageInfo<>(userList);
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

	@Override
	public List<SysUserRole> findUserRoles(String userId) {
		return sysUserRoleMapper.findUserRoles(userId);
	}

}
