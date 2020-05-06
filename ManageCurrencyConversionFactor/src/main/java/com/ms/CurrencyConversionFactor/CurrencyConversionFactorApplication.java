package com.ms.CurrencyConversionFactor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CurrencyConversionFactorApplication {
	
	@Autowired
	ConversionFactorJPARepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionFactorApplication.class, args);
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

			List<ConversionFactor> country = new ArrayList<ConversionFactor>();
			repo.save(new ConversionFactor("91", 1));
			repo.save(new ConversionFactor("1", 70));
			repo.save(new ConversionFactor("89", 60));
			repo.save(new ConversionFactor("7", 100));
			repo.save(new ConversionFactor("74", 80));

			System.out.println("Saved " + country.size());

		};
	

}


}
