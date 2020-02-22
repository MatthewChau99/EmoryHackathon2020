package com.example.Hackathon.Repository;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food getById(Long id);
}
