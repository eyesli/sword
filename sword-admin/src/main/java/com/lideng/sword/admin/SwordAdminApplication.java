package com.lideng.sword.admin;

import com.lideng.sword.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages={"com.lideng.sword.admin"})
//@SpringBootApplication(scanBasePackages= {"com.lideng.sword.admin", "com.lideng.sword.admin"})
/**
 * 项目启动入口
 * @author lideng
 * @date July 30, 2019
 */
@EnableJpaAuditing
public class SwordAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwordAdminApplication.class, args);
	}
	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}



}
