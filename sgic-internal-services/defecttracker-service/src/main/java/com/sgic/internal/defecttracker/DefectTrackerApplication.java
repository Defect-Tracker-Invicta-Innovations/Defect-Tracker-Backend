package com.sgic.internal.defecttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.eureka.common.dto.mapper.Mapper;
import com.sgic.internal.defecttracker.defectservice.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class DefectTrackerApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(DefectTrackerApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Mapper getMapper() {
		return new Mapper();
	}
}
