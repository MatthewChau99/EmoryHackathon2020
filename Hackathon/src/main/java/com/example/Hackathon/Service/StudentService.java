package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Repository.StudentRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Accessors
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long Id) {
        return studentRepository.getById(Id);
    }

    public Student createStudent(@RequestParam String name, @RequestParam String email, @RequestParam String origin) {
        Student student = new Student().setName(name).setEmail(email).setOrigin(origin);
        studentRepository.saveAndFlush(student);
        return student;
    }

    public int deleteStudent(Long Id) {
        studentRepository.deleteById(Id);
        return 1;
    }

    public int updateStudent(Long Id, Student newStudent) {
        studentRepository.deleteById(Id);
        studentRepository.saveAndFlush(newStudent);
        return 1;
    }
}