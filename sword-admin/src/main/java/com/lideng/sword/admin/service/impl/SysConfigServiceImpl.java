package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lideng.sword.admin.model.entity.DelStatus;
import com.lideng.sword.admin.model.entity.SysConfig;
import com.lideng.sword.admin.model.entity.Teacher;
import com.lideng.sword.admin.model.entity.User;
import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;
import com.lideng.sword.admin.repository.ConfigRepository;
import com.lideng.sword.admin.repository.MenuRepository;
import com.lideng.sword.admin.repository.RoleRepository;
import com.lideng.sword.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lideng.sword.admin.service.SysConfigService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysConfigServiceImpl  implements SysConfigService {


	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MenuRepository menuRepository;
	@Autowired
	ConfigRepository configRepository;

	@Override
	public String create(SysConfigSaveDTO sysConfigSaveDTO) {

		SysConfig sysConfig =new SysConfig();
		BeanUtils.copyProperties(sysConfigSaveDTO,sysConfig);
		sysConfig.setDelFlag(DelStatus.NORMAL);
		sysConfig.setVersion(0);
		return configRepository.save(sysConfig).getId();
	}

	@Override
	public String update(SysConfigUpdateDTO record) {

		SysConfig sysConfig = configRepository.getOne(record.getId());
		BeanUtils.copyProperties(record,sysConfig);
		sysConfig.setVersion(sysConfig.getVersion()+1);
		return configRepository.save(sysConfig).getId();
	}


	@Override
	public int delete(List<String> ids) {
		ids.forEach(id->configRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public SysConfig findById(String id) {
		return configRepository.getOne(id);
	}

	@Override
	public List<User> test(String label) {

//		//List<User> all = UserRepository.
//		SysUser sysUser1 = userRepository.findById("1260081237888995328").orElseThrow(NoSuchElementException::new);
//
//
//		SysUser sysUser = new SysUser();
//		sysUser.setName("sysUser4");
//		sysUser.setVersion(0);
//		List<String> list= new ArrayList<String>();
//		list.add("3");
//		list.add("4");
//
//		List<SysMenu> allById = menuRepository.findAllById(list);
//
//
//		SysRole sysRole = new SysRole();
//
//		sysRole.setName("天堂经理");
//		sysRole.setSysMenu(allById);
//		SysRole save = roleRepository.save(sysRole);
//		PageRequest pageRequest = PageRequest.of(0, 1);
//		//Page<List<UserDTO>> userById = userRepository.findUserById("1", UserDTO.class, pageRequest);
//


//		List<User> all = userRepository.findAll(createSpecification("stud1", "Tea wang"));
//		System.out.println(all);
//		List all1 = userRepository.findAll();

		return null;
	}

	@Override
	public List<SysConfig> findByLabel(String label) {
		return configRepository.findByLabel(label);
	}




	private Specification<User> createSpecification(String username,String teachername) {

		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)-> {

			List<Predicate> predicateList = new ArrayList<>();

			//predicateList.add(cb.equal(root.get("name").as(String.class), username));

			//左连接
			Join<User, Teacher> join = root.join("teachers", JoinType.LEFT);
			predicateList.add(cb.equal(join.get("name"),teachername));

			Predicate predicate =cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			return query.where(predicate).getRestriction();
		};
	}

}
