package com.lideng.sword.admin.service.impl;

import java.util.Date;
import java.util.List;

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
	UserRepository UserRepository;

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
		List userById = UserRepository.findUserById(1L, UserDTO.class);
		//UserRepository.
		System.out.println(userById);
		return null;
	}

	@Override
	public List<SysConfig> findByLabel(String label) {
		return sysConfigMapper.findByLable(label);
	}

}
