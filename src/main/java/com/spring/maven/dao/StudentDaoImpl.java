package com.spring.maven.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.spring.maven.bean.Student;

public class StudentDaoImpl implements StudentDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void create(String firstName, String lastName, String college) {
		String SQL = "insert into Student (firstName,lastName,college) values (?, ?, ?)";
	      jdbcTemplateObject.update( SQL, firstName,lastName,college);
	      System.out.println("Created Record Name = " + firstName+" "+lastName + " College = " + college);
	      return;
	}
	
	public Student getStudent(Integer studentId) {
		String sql = "select * from Student where studentId=?";
		Student student = jdbcTemplateObject.queryForObject(sql, new Object[]{studentId},new StudentMapper());
		return student;
	}

	public List<Student> listStudents() {
		String sql = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(sql,new StudentMapper());
		return students;
	}

	public void delete(Integer studentId) {
		  String SQL = "delete * from Student where studentId = ?";
	      jdbcTemplateObject.update( SQL, studentId);
	      System.out.println("Deleted Record with studentId = " +studentId);
	      return;
		
	}

	public void update(Integer studentId, String college) {
		  String SQL = "update Student set college = ? where studentId = ?";
	      jdbcTemplateObject.update( SQL, college,studentId);
	      System.out.println("Updated Record with studentId"+studentId+ " with college = " + college);
	      return;
		
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	      this.jdbcTemplateObject = new JdbcTemplate(ds);
		
	}

}
