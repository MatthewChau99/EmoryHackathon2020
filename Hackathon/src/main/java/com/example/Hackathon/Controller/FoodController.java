package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Models.Student;
import com.example.Hackathon.Service.FoodService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

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
    public Person getById(@PathVariable("id") Long id){
        return foodService.getById(id)
                .orElse(null);
    }
}
