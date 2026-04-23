package com.learning.multipleContainer.controller;

import com.learning.multipleContainer.model.Student;
import com.learning.multipleContainer.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentRepo repo;

    @GetMapping("/getStudent")
    public List<Student> getStudent(){
        return repo.findAll();
    }
}
