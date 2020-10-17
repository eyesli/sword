package com.lideng.sword.admin.service.impl;

import java.util.List;

import com.lideng.sword.admin.model.request.SysDictCreateDTO;
import com.lideng.sword.admin.model.request.SysDictUpdateDTO;
import com.lideng.sword.admin.repository.DictRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lideng.sword.admin.model.entity.SysDict;
import com.lideng.sword.admin.service.SysDictService;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysDictServiceImpl  implements SysDictService {

	@Autowired
	private DictRepository dictRepository;


	@Override
	public String create(SysDictCreateDTO record) {

		SysDict sysDict =new SysDict();
		BeanUtils.copyProperties(record,sysDict);
		sysDict.setVersion(0);
		return dictRepository.save(sysDict).getId();
	}

	@Override
	public String update(SysDictUpdateDTO record) {

		SysDict sysDict = dictRepository.getOne(record.getId());
		BeanUtils.copyProperties(record,sysDict);
		sysDict.setVersion(sysDict.getVersion()+1);
		return dictRepository.save(sysDict).getId();
	}

	@Override
	public int delete(List<String> ids) {

		ids.forEach(id->dictRepository.deleteById(id));
		return ids.size();
	}

	@Override
	public SysDict findById(String id) {
		return dictRepository.getOne(id);
	}

	@Override
	public List<SysDict> findByLabel(String label) {
		return dictRepository.findByLabel(label);
	}

}
