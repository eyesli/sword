package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.lideng.sword.admin.model.entity.SysDept;
import com.lideng.sword.admin.model.request.SysDeptCreateDTO;
import com.lideng.sword.admin.model.request.SysDeptUpdateDTO;
import com.lideng.sword.admin.repository.SysDeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lideng.sword.admin.service.SysDeptService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
/**
 * @author lideng
 * @date 2019/10/09
 */
public class SysDeptServiceImpl implements SysDeptService {


	@Autowired
	SysDeptRepository sysDeptRepository;

	@Override
	public String create(SysDeptCreateDTO record) {

		SysDept sysDept =new SysDept();
		BeanUtils.copyProperties(record,sysDept);
		sysDept.setVersion(0);
		sysDept.setParentId(record.getParentId());
		return sysDeptRepository.save(sysDept).getId();
	}

	@Override
	public String update(SysDeptUpdateDTO record) {

		SysDept sysDept = sysDeptRepository.getOne(record.getId());
		BeanUtils.copyProperties(record,sysDept);
		sysDept.setVersion(sysDept.getVersion()+1);
		return sysDeptRepository.save(sysDept).getId();
	}


	@Override
	public void delete(String id) {

		//todo 删除部门之前是不是应该先判断有没有user
		sysDeptRepository.deleteById(id);
		//return ids.size();
	}

	@Override
	public SysDept findById(String id) {
		return sysDeptRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<SysDept> findTree() {
		List<SysDept> sysDepts = new ArrayList<>();
		List<SysDept> depts = sysDeptRepository.findAll();
		for (SysDept dept : depts) {
			if (StringUtils.isBlank(dept.getParentId())) {
				dept.setLevel(0);
				sysDepts.add(dept);
			}
		}
		findChildren(sysDepts, depts);
		return sysDepts;
	}

	private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
		for (SysDept sysDept : sysDepts) {
			List<SysDept> children = new ArrayList<>();
			for (SysDept dept : depts) {
				if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
					dept.setParentName(dept.getName());
					dept.setLevel(sysDept.getLevel() + 1);
					children.add(dept);
				}
			}
			sysDept.setChildren(children);
			findChildren(children, depts);
		}
	}

}
