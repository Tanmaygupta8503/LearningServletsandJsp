package com.springcore.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/constructorInjection/certiconfig.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person);
		System.out.println();
		System.out.println();
		Addition add = (Addition)context.getBean("add");
		System.out.println(add.sum());
	}
}
