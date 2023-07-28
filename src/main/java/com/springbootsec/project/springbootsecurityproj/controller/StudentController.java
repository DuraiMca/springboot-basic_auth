package com.springbootsec.project.springbootsecurityproj.controller;


import com.springbootsec.project.springbootsecurityproj.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class StudentController {
    ArrayList<Student>list=new ArrayList<>();


   @GetMapping("/getstudents")
    public ArrayList<Student> getStudents(){
       list.add(new Student(1,"Durai","duraidur52@gmail.com"));
        list.add(new Student(2,"Murugan","durai@gmail.com"));
        return list;
    }

   @PostMapping("/insertStudent")
    public  Student insertStudent(@RequestBody Student student){
      list.add(student);
      return student;
    }
}
