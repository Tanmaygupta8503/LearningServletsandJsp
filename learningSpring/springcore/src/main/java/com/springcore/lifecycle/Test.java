package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
//		Samosa samosa = (Samosa) context.getBean("samosa");
//		System.out.println(samosa);
		context.registerShutdownHook();
		
		System.out.println("____________________________________________________________________");
		
//		Pepsi pepsi = (Pepsi) context.getBean("pepsi");
//		System.out.println(pepsi);
		System.out.println("____________________________________________________________________");
		
		Student Tanmay = (Student)context.getBean("Tanmay");
		System.out.println(Tanmay);
	}

}
