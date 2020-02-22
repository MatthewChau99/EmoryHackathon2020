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

    public Food createFood(Food food) {
        foodRepository.saveAndFlush(food);
        return food;
    }

    public Food saveOrUpdateFood(Food food) {
        return foodRepository.saveAndFlush(food);
    }

    public int deleteFood(Long Id){
        foodRepository.deleteById(Id);
        return 1;
    }

    public int updateFood(Long Id, Food newFood) {
        foodRepository.deleteById(Id);
        foodRepository.saveAndFlush(newFood);
        return 1;
    }
}
