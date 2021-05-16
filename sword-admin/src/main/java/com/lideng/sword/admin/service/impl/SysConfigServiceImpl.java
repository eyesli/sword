package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

import com.lideng.sword.admin.event.UserEvent;
import com.lideng.sword.admin.model.entity.*;
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
	private ApplicationContext applicationContext;



	@Override
	public String create(SysConfigSaveDTO sysConfigSaveDTO) {

//		configRepository.
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





//	Queue<String> a = new ArrayBlockingQueue<String>(100);
//	Queue<String> b = new ArrayBlockingQueue<String>(100);
	List<String> a =new ArrayList<String >(1);
	List<String> b =new ArrayList<String >(1);
	Executor executor = Executors.newFixedThreadPool(1);
	final CyclicBarrier barrier = new CyclicBarrier(2, ()->{
		executor.execute(this::check);
	});
	int i=0;
	int j=0;
	@Override
	public List<User> test(String label) {
		// 循环查询订单库

		Thread T1 = new Thread(()->{
			while(j<100000){
				// 查询订单库
				a.add("aaa"+j++);
				// 等待
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		T1.start();
		// 循环查询运单库
		Thread T2 = new Thread(()->{

			while(i<100000){
				// 查询运单库
				b.add("bbb"+i++);
				// 等待
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		T2.start();
		return null;
	}
	void check(){
		System.out.println(i+"#");
		System.out.println(j+"#");
		String  poll1 = a.remove(0);
		String poll2 = b.remove(0);
		String s = poll1 +"###"+poll2;

		System.out.println(s);
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
