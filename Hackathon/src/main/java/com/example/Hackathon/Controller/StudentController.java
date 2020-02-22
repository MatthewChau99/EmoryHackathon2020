package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Repository.StudentRepository;
import com.example.Hackathon.Service.StudentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

}
