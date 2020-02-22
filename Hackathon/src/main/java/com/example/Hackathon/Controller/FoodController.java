package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Service.FoodService;
import lombok.NonNull;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/all")
    public Iterable<Food> findAll() {
        return foodService.findAll();
    }

    @PostMapping
    public void createFood(@Valid @NonNull @RequestBody String name, String origin, Boolean org) {
        foodService.createFood(name, origin, org);
    }

    @GetMapping(path = "{id}")
    public Food getById(@PathVariable("id") Long id){
        return foodService.getById(id);
    }
}
