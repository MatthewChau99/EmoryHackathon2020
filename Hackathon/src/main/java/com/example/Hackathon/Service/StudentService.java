package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Rating;
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

    public int deleteStudent(Long Id) {
        studentRepository.deleteById(Id);
        return 1;
    }

    public int updateStudent(Long Id, Student newStudent) {
        studentRepository.deleteById(Id);
        studentRepository.saveAndFlush(newStudent);
        return 1;
    }

    public int addFood(Long Id, String food){
        Student student = studentRepository.getById((Id));
        String foodList = student.getFoodlist() + (" " + food);
        student.setFoodList(foodList);
        return 1;
    }
}