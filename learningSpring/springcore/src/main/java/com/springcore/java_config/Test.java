package com.springcore.java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Demo demo = context.getBean("demo", Demo.class);
		System.out.println(demo);
		demo.study();
	}
}
