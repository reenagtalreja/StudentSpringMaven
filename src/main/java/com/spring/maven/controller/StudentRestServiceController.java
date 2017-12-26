package com.spring.maven.controller;
/*This controller is not required for spring jdbc */
/*This is an example of rest services spring*/
/* MainApp is used to run jdbc */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.maven.bean.Student;

@Controller
public class StudentRestServiceController {
	private static Map<Integer,Student> studentsData = new HashMap<Integer,Student>();
	 
    @RequestMapping("/students")
    public @ResponseBody List<Student> getAllStudents()
    {
      Set<Integer> set = studentsData.keySet();
      Iterator<Integer> it = set.iterator();
      List<Student> students = new ArrayList<Student>();
      while(it.hasNext())
        {
         Integer id = it.next();
         students.add(studentsData.get(id));
        } 
      return students;
    }
    @RequestMapping("/student/{studentId}")
    public @ResponseBody Student getStudent(@PathVariable("studentId") Integer id)
    {
      return studentsData.get(id); 
    }
   @RequestMapping(value ="/student/delete/{studentId}" ,method=RequestMethod.DELETE)
   public @ResponseBody Student deleteStudent(@PathVariable("studentId") Integer id)
   {
     return studentsData.remove(id);
   }

   @RequestMapping(value ="/student/add" ,method=RequestMethod.POST)
   public @ResponseBody Student  addStudent(@RequestBody Student studnet)
   {
      studentsData.put(studnet.getStudentId(), studnet);
      return studnet;
   }
}
