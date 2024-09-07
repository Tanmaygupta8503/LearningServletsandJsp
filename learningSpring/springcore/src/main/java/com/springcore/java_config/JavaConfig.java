package com.springcore.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.springcore.java_config")
public class JavaConfig {
	@Bean
	public Samosa getSamosa() {
		return new Samosa();
	}
	@Bean
	public Demo demo() {
		return new Demo(getSamosa());
	}
}
