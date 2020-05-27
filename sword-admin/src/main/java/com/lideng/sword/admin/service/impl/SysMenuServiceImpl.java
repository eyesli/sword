package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.lideng.sword.admin.model.entity.MenuType;
import com.lideng.sword.admin.model.entity.SysUser;
import com.lideng.sword.admin.model.request.SysMenuCreateDTO;
import com.lideng.sword.admin.model.request.SysMenuUpdateDTO;
import com.lideng.sword.admin.repository.MenuRepository;
import com.lideng.sword.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lideng.sword.admin.constant.SysConstants;
import com.lideng.sword.admin.model.entity.SysMenu;
import com.lideng.sword.admin.service.SysMenuService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private UserRepository userRepository;



	@Override
	public String create(SysMenuCreateDTO record) {
		SysMenu sysMenu =new SysMenu();
		BeanUtils.copyProperties(record,sysMenu);
		sysMenu.setVersion(0);
		return menuRepository.save(sysMenu).getId();

	}

	@Override
	public String update(SysMenuUpdateDTO record) {

		SysMenu sysMenu = menuRepository.getOne(record.getId());
		BeanUtils.copyProperties(record,sysMenu);
		sysMenu.setVersion(sysMenu.getVersion()+1);
		return menuRepository.save(sysMenu).getId();
	}


	@Override
	public int delete(List<String> ids) {
		ids.forEach(id->menuRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public SysMenu findById(String id) {
		return menuRepository.getOne(id);
	}

	@Override
	public List<SysMenu> findTree(String userName, int menuType) {
		List<SysMenu> sysMenus = new ArrayList<>();
		List<SysMenu> menus = findByUser(userName);
		for (SysMenu menu : menus) {
			if ("0".equals(menu.getParentId())) {
				menu.setLevel(0);
				menu.setKey(menu.getId());
				menu.setValue(menu.getId());
				menu.setTitle(menu.getName());
				if(!exists(sysMenus, menu)) {
					sysMenus.add(menu);
				}
			}
		}
		sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
		findChildren(sysMenus, menus, menuType);
		return sysMenus;
	}

	@Override
	public List<SysMenu> findByUser(String userName) {
		if(StringUtils.isBlank(userName) || SysConstants.ADMIN.getValue().equalsIgnoreCase(userName)) {
			return menuRepository.findAll();
		}
		SysUser byName = userRepository.findByName(userName).get();
		return byName.getSysRole().getSysMenu();
	}

	private void findChildren(List<SysMenu> SysMenus, List<SysMenu> menus, int menuType) {
		for (SysMenu SysMenu : SysMenus) {
			List<SysMenu> children = new ArrayList<>();
			for (SysMenu menu : menus) {
				if(menuType == 1 && menu.getType() .equals(MenuType.BUTTON)) {
					// 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
					continue ;
				}
				if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
					menu.setParentName(SysMenu.getName());
					menu.setLevel(SysMenu.getLevel() + 1);
					menu.setKey(menu.getId());
					menu.setValue(menu.getId());
					menu.setTitle(menu.getName());
					if(!exists(children, menu)) {
						children.add(menu);
					}
				}
			}
			SysMenu.setChildren(children);
			children.sort(Comparator.comparing(com.lideng.sword.admin.model.entity.SysMenu::getOrderNum));
			findChildren(children, menus, menuType);
		}
	}

	private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
		boolean exist = false;
		for(SysMenu menu:sysMenus) {
			if(menu.getId().equals(sysMenu.getId())) {
				exist = true;
			}
		}
		return exist;
	}
	
}
