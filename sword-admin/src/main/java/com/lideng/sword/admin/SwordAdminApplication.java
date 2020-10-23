package com.lideng.sword.admin;

import com.lideng.sword.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "com.lideng.sword.admin.dao")
@ComponentScan(basePackages = "com.lideng.sword.admin.config")
@SpringBootApplication(scanBasePackages={"com.lideng.sword.admin"})
/**
 * 项目启动入口
 * @author lideng
 * @date July 30, 2019
 */

public class SwordAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwordAdminApplication.class, args);
	}
	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

}
