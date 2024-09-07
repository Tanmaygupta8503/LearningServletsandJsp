package com.spring.orm;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import com.spring.orm.dao.StudentDao;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
    	StudentDao studentDao = context.getBean("studentDao" , StudentDao.class);
//    	Student student = new Student();
//    	student.setStudentId(8081);
//    	student.setStudentName("Sindbad");
//    	student.setStudentCity("Arab");
//    	System.out.println("Number of rows changed " + studentDao.insert(student));
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("********Welcome to Student Data Software ******");
    	boolean go = true;
    	while(go) {
    		System.out.println("PRESS 1 to ADD new Student");
    		System.out.println("PRESS 2 to Display All Student");
    		System.out.println("PRESS 3 to Display one Student");
    		System.out.println("PRESS 4 to Delete Student");
    		System.out.println("PRESS 5 to Update Student");
    		System.out.println("PRESS 6 to Exit");
    		int choice = scanner.nextInt();
    		try {
    			
    			switch(choice){
	    			case 1 : 
	    				Student student = new Student();
	    				System.out.println("Enter student id");
	    				int id = scanner.nextInt();
	    				student.setStudentId(id);
	    				System.out.println("Enter Student name");
	    				String name = scanner.next();
	    				student.setStudentName(name);
	    				System.out.println("Enter Student City");
	    				String city = scanner.next();
	    				student.setStudentCity(city);
	    				studentDao.insert(student);
	    				break;
	    			case 2: 
	    				studentDao.getAllStudent();
	    				break;
	    			case 3: 
	    				System.out.println("Enter the Student Id of the Student you want to display");
	    				int StudentId = scanner.nextInt();
	    				studentDao.getStudent(StudentId);
	    				break;
	    			case 4:
	    				System.out.println("Enter the Student Id of the Student you want to delete");
	    				int Student_Id = scanner.nextInt();
	    				studentDao.deleteStudent(Student_Id);
	    				break;
	    			case 5: 
	    				System.out.println("Enter the Student Id of the Student you want to update");
	    				int student_id = scanner.nextInt();
	    				System.out.println("Enter the student name");
	    				String Sname = scanner.next();
	    				System.out.println("Enter the student city");
	    				String Scity = scanner.next();
	    				Student updatedStudent = new Student(student_id , Sname , Scity);
	    				studentDao.updateStudent(updatedStudent);
	    				break;
	    			case 6:
	    				go = false;
	    				break;
    			}
    		}catch(Exception e) {
    			System.out.println("Invalic Input try with other one !!!");
    			System.out.println(e.getMessage());
    		}
    	}
    	System.out.println("Thankyou see you soon");
		scanner.close();
    }
}
