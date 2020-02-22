package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Iterable<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food getById(Long Id) {
        return foodRepository.getById(Id);
    }

    public Food createFood(String name, String origin, Boolean org) {
        Food food = new Food().setName(name).setOrigin(origin);
        foodRepository.saveAndFlush(food);
        return food;
    }
}
