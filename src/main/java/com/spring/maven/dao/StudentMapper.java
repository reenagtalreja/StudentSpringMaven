package com.spring.maven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.maven.bean.Student;

public class StudentMapper implements RowMapper<Student> {
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Student student = new Student();
	   student.setStudentId(rs.getInt("studentId"));
	   student.setFirstName(rs.getString("firstName"));
	   student.setLastName(rs.getString("lastName"));
	   student.setCollege(rs.getString("college"));
	   return student;
   }
   
}