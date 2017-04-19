package org.myproject.config;


import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	public Mapper getMapper(){
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
}
