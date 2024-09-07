package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImplement implements StudentDao{
	@Autowired
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.template.update(query , student.getId() , student.getName(),student.getCity());
		return r;
	}
	public int change(Student student) {
		String query = "update student set name=? , city=? where id=?";
		int r = this.template.update(query , student.getName(),student.getCity(),student.getId());
		return r;
	}
	public int delete(int id) {
		String query = "delete from student where id=?";
		int r = this.template.update(query , id);
		return r;	
	}
	
	public Student getStudent(int id) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImplement();
		Student student = this.template.queryForObject(query, rowMapper , id);
		return student;
	}
	public List<Student> getAllStudent() {
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImplement();
		List<Student> studentList = this.template.query(query, rowMapper);
		return studentList;
	}
}
