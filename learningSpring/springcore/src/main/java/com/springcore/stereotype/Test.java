package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereotype/config.xml");
		Student student = context.getBean("student" , Student.class);
		System.out.println(student.hashCode());
		Student student1 = context.getBean("student" , Student.class);
		System.out.println(student1.hashCode());
		Teacher teacher = context.getBean("teacher" , Teacher.class);
		System.out.println(teacher.hashCode());
		Teacher teacher1 = context.getBean("teacher" , Teacher.class);
		System.out.println(teacher1.hashCode());
	}
}
