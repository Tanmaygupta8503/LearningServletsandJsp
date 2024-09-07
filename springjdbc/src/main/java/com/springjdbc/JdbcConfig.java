package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImplement;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JdbcConfig {
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");;
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");;
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("template")
	public JdbcTemplate getTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());;
		return template;
	}
//	@Bean(name= {"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImplement studentDao = new StudentDaoImplement();
//		studentDao.setTemplate(getTemplate());
//		return studentDao;
//	}
}
