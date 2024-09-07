package com.firstProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static ApplicationContext context;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // Load the Spring context from the XML configuration file
        context = SpringApplication;
        
        // Retrieve the Student bean from the context
        Student student1 = (Student) context.getBean("student1");
        
        // Print the Student object details
        System.out.println(student1);
    }
}
