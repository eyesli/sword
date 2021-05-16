package com.lideng.sword.admin;

import com.lideng.sword.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author admin
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
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
