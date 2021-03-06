package com.example.Hackathon.Repository;

import com.example.Hackathon.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getById(Long Id);
}
