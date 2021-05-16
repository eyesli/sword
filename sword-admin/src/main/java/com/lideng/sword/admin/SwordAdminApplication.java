package com.lideng.sword.admin;

import com.lideng.sword.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication()
/**
 * 项目启动入口
 * @author lideng
 * @date July 30, 2019
 */
@EnableDiscoveryClient
public class SwordAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwordAdminApplication.class, args);
	}
	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

}
