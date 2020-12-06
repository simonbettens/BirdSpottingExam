package com.springBoot.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;
import validator.BirdSpecieValidator;

@SpringBootApplication
public class BirdSpottingExamenWebappsApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BirdSpottingExamenWebappsApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403");
	}
	
	@Bean
    public SpottedBirdService spottedBirdService() {
        return new SpottedBirdServiceImpl();
    }
	@Bean 
	public BirdSpecieValidator birdSpecieValditor() {
		return new BirdSpecieValidator();
	}
	
	@Override
    public void addResourceHandlers(
                              ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").
                                addResourceLocations("resources/css/");
    }

}
