package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Models.Rating;
import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Repository.StudentRepository;
import com.example.Hackathon.Service.RatingService;
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

    @GetMapping("/all")
    public Iterable<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    public void createStudent(String name, String email, String origin) {
        studentService.createStudent(name, email, origin);
    }

    @GetMapping(path = "{id}")
    public Student getById(@PathVariable("id") Long id){
        return studentService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {studentService.deleteStudent(id);}

    @PutMapping(path = "{id}")
    public void updatingStudent(@PathVariable("id") Long id,@RequestBody Student newStudent) {
        studentService.updateStudent(id,newStudent);

    }