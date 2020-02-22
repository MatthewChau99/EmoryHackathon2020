package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public Iterable<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/new")
    public void createStudent(@RequestParam String name, @RequestParam String email, @RequestParam String origin) {
        studentService.createStudent(name, email, origin);
    }

    @GetMapping(path = "{id}")
    public Student getById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updatingStudent(@PathVariable("id") Long id, @RequestBody Student newStudent) {
        studentService.updateStudent(id, newStudent);
    }
}