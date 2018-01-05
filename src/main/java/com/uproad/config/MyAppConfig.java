package com.uproad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.uproad.interceptor.AuthorInterceptor;

@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new AuthorInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/api/**").allowedOrigins("http://localhost:4200");
		super.addCorsMappings(registry);
	}

}
