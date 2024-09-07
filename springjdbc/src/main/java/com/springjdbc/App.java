package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

public class App {
	private static ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("My Program Started .........!!!");
//		context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
		context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
//		String query = "insert into student(id,name,city) values(?,?,?)";
//		int result = template.update(query , 29932 , "Dhruv" , "Kanpur");
//		System.out.println("number of records inserted " + result);
		/*
		 * StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		 * Student student = new Student(); student.setId(30561);
		 * student.setName("Shri Narayan"); student.setCity("Kanpur"); int result =
		 * studentDao.insert(student); System.out.println("Numbers of Rows Affected " +
		 * result);
		 */
		/*
		 * StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		 * Student student = new Student(); student.setId(30551);
		 * student.setName("Tanmay Gupta"); student.setCity("PSIT , Uttar Pradesh"); int
		 * result = studentDao.change(student);
		 * System.out.println("Numbers of Rows Affected " + result);
		 */
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		int result = studentDao.delete(30551);
//		System.out.println("Numbers of Rows Affected " + result);
//		System.out.println(studentDao.getStudent(30706));
		for(Student student : studentDao.getAllStudent()) {
			System.out.println(student);
		}
	}
}
