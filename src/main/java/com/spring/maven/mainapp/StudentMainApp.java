package com.spring.maven.mainapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.spring.maven.bean.Student;
import com.spring.maven.dao.StudentDaoImpl;
import com.spring.maven.generic.dao.todo.BaseObjectMapper;
/*
 * Create a table student in student schema in mysql database before running this program
 * 
	create table student(studentId int(10) auto_increment,
	firstname varchar(20),
	lastname varchar(20),
	college varchar(100),
	primary key(studentId));
*
*
 */
public class StudentMainApp {
public static void main(String args[]) {
	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

     StudentDaoImpl studentDaoImplObject = 
        (StudentDaoImpl)context.getBean("studentDaoImplObject");
     
     System.out.println("------Records Creation--------" );
     studentDaoImplObject.create("Zara","Shah", "ANMT");
     studentDaoImplObject.create("Nuha", "Shaha","ANMT");
     studentDaoImplObject.create("Ayan", "ROY","UTD");

     System.out.println("------Listing Multiple Records--------" );
     List<Student> students = studentDaoImplObject.listStudents();
     
     for (Student record : students) {
        System.out.print("ID : " + record.getStudentId());
        System.out.print(", Name : " + record.getFirstName()+" "+record.getLastName() );
        System.out.println(", College : " + record.getCollege());
     }

     System.out.println("----Updating Record with ID = 2 -----" );
     studentDaoImplObject.update(2, "UTD");

     System.out.println("----Listing Record with ID = 2 -----" );
     Student student = studentDaoImplObject.getStudent(2);
     System.out.print("ID : " + student.getStudentId() );
     System.out.print(", Name : " + student.getFirstName()+" "+student.getLastName() );
     System.out.println(", College : " + student.getCollege());
}
}
