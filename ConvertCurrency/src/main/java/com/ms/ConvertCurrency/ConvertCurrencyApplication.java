package com.ms.ConvertCurrency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class ConvertCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertCurrencyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner inspect(ApplicationContext ctx) {
		return (r) -> {
			int beanCount = ctx.getBeanDefinitionCount();
			String[] beans = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beanCount);
			for (int i = 0; i < beanCount; i++) {
				// System.out.println(beans[i]);
			}

			
		};
	}


}
