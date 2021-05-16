package com.lideng.sword.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import com.lideng.sword.admin.dao.SysRoleMenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	private SysRoleMenuMapper mapper;


	List<String> a =new ArrayList< >(1);
	List<String> b =new ArrayList< >(1);
	Executor executor = Executors.newFixedThreadPool(1);
	final CyclicBarrier barrier = new CyclicBarrier(2, ()->{
		executor.execute(this::check);
	});
	int i=0;
	int j=0;
	@Override
	public String test( ) {
		// 循环查询订单库

		Thread T1 = new Thread(()->{
			while(j<100000){
				// 查询订单库
				a.add(mapper.sa(i));
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


}
