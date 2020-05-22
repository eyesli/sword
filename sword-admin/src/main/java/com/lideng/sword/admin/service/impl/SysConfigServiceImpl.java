package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lideng.sword.admin.event.UserEvent;
import com.lideng.sword.admin.model.entity.*;
import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;
import com.lideng.sword.admin.mq.Sender;
import com.lideng.sword.admin.repository.ConfigRepository;
import com.lideng.sword.admin.repository.MenuRepository;
import com.lideng.sword.admin.repository.RoleRepository;
import com.lideng.sword.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.*;

import org.springframework.context.ApplicationContext;
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

	@Autowired
	Sender sender;

	@Autowired
	private ApplicationContext applicationContext;



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


		sender.send();
		SysUser sysUser = new SysUser();
		sysUser.setName("54321");
		sysUser.setVersion(0);
		UserEvent userevent = new UserEvent(this,sysUser);
		applicationContext.publishEvent(userevent);

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
