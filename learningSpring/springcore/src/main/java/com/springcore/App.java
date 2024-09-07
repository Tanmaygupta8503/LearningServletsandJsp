package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springcore.collection.Employee;
import com.springcore.reference.A;

import java.io.File;

public class App {
    private static ApplicationContext context;
    private static ApplicationContext employeeContext;

    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");

            // Load the context for Student beans
            context = new ClassPathXmlApplicationContext("config.xml");

            System.out.println("Print the Student1");
            Student student1 = (Student) context.getBean("student1");
            System.out.println(student1+"\n");

            System.out.println("Print the Student2");
            Student student2 = (Student) context.getBean("student2");
            System.out.println(student2+"\n");

            System.out.println("Print the Student3");
            Student student3 = (Student) context.getBean("student3");
            System.out.println(student3+"\n");
            System.out.println();
//            System.out.println();
//            System.out.println();

            // Print the current working directory
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("Current working directory: " + currentDirectory+"\n");

            // Load the context for Employee beans
            employeeContext = new ClassPathXmlApplicationContext("com/springcore/collection/config.xml");
            Employee employee1 = (Employee) employeeContext.getBean("employee1");
            System.out.println(employee1+"\n");
            
            System.out.println();
//            System.out.println();
//            System.out.println();
            
            
            //Load the context of A injected with B class object and both are injected with dependency injection
            ApplicationContext acontext = new ClassPathXmlApplicationContext("com/springcore/reference/config.xml");
            A a = (A) acontext.getBean("aref");
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
