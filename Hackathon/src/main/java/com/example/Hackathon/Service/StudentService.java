package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Student createStudent(String name, String email, String origin) {
        Student student = new Student().setName(name).setEmail(email).setOrigin(origin);
        studentRepository.saveAndFlush(student);
        return student;
    }
}
