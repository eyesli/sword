package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lideng.sword.admin.jpa.Teacher;
import com.lideng.sword.admin.jpa.User;
import com.lideng.sword.admin.jpa.UserDTO;
import com.lideng.sword.admin.model.request.SysConfigSaveDTO;
import com.lideng.sword.admin.model.request.SysConfigUpdateDTO;
import com.lideng.sword.admin.repository.UserRepository;
import com.lideng.sword.admin.util.SecurityUtils;
import com.lideng.sword.common.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lideng.sword.admin.dao.SysConfigMapper;
import com.lideng.sword.admin.model.entity.SysConfig;
import com.lideng.sword.admin.service.SysConfigService;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import static com.lideng.sword.admin.constant.SysConstants.USERNAME;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysConfigServiceImpl  implements SysConfigService {

	@Autowired
	SysConfigMapper sysConfigMapper;

	@Autowired
	IdWorker idWorker;

	@Autowired
	UserRepository userRepository;

	@Override
	public int create(SysConfigSaveDTO sysConfigSaveDTO, HttpServletRequest request) {

		//todo 可以从这里获取登陆的用户名  HttpServletRequest 可以删掉了
		String username = SecurityUtils.getUsername();
		SysConfig sysConfig =new SysConfig();
		BeanUtils.copyProperties(sysConfigSaveDTO,sysConfig);
		log.info(sysConfig.toString());
		sysConfig.setId(idWorker.nextId() + "");
		sysConfig.setCreateTime(new Date());
		sysConfig.setCreateBy((String) request.getSession().getAttribute(USERNAME.getValue()));
		sysConfig.setDelFlag(true);
		sysConfig.setVersion(0);
		log.info(sysConfig.toString());
		return sysConfigMapper.insert(sysConfig);
	}

	@Override
	public int update(SysConfigUpdateDTO record,HttpServletRequest request) {

		SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(record.getId());
		BeanUtils.copyProperties(record,sysConfig);
		sysConfig.setLastUpdateBy((String) request.getSession().getAttribute(USERNAME.getValue()));
		sysConfig.setLastUpdateTime(new Date());
		sysConfig.setVersion(sysConfig.getVersion()+1);
		log.info(sysConfig.toString());
		return sysConfigMapper.updateByPrimaryKey(sysConfig);
	}


	@Override
	public int delete(List<String> ids) {
		ids.forEach(id->sysConfigMapper.updateDeleteFlagByid(id));
		return ids.size();
	}

	@Override
	public SysConfig findById(String id) {
		return sysConfigMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> test(String label) {

		//List<User> all = UserRepository.
		//UserDTO userById = userRepository.findUserById(1L);
		PageRequest pageRequest = PageRequest.of(0, 1);
		//Page<List<UserDTO>> userById = userRepository.findUserById("1", UserDTO.class, pageRequest);



		List<User> all = userRepository.findAll(createSpecification("stud1", "Tea wang"));
		System.out.println(all);
		List all1 = userRepository.findAll();

		return all1;
	}

	@Override
	public List<SysConfig> findByLabel(String label) {
		return sysConfigMapper.findByLable(label);
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
