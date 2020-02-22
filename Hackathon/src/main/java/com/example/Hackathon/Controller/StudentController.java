package com.example.Hackathon.Controller;

import com.example.Hackathon.Repository.StudentRepository;
import com.example.Hackathon.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
}
