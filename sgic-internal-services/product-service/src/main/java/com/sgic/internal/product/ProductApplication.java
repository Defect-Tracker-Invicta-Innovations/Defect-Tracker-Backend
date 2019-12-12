package com.sgic.internal.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.eureka.common.dto.mapper.Mapper;

@SpringBootApplication
public class ProductApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public Mapper getMapper() {
		return new Mapper();
	}
}
