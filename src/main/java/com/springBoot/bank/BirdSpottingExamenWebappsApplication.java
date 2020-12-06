package com.springBoot.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;

@SpringBootApplication
public class BirdSpottingExamenWebappsApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BirdSpottingExamenWebappsApplication.class, args);
	}
	
	@Bean
    public SpottedBirdService countryValidator() {
        return new SpottedBirdServiceImpl();
    }
	
	@Override
    public void addResourceHandlers(
                              ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").
                                addResourceLocations("resources/css/");
    }

}
