package com.spring.orm.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import java.util.List;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	//save Student
	@Transactional
	public int insert(Student student) {
		int r = (int)this.hibernateTemplate.save(student);
		return r;
	}
	//get the single data(object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	//get all objects
	public List<Student> getAllStudent() {
		List<Student> studentList= this.hibernateTemplate.loadAll(Student.class);
		return studentList;
	}
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class , studentId);
		this.hibernateTemplate.delete(student);
	}
	//updating data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
