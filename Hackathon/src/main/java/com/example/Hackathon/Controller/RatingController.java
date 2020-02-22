package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Rating;
import com.example.Hackathon.Service.RatingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/all")
    public Iterable<Rating> findAll() {
        return ratingService.findAll();
    }

    @PostMapping
    public void createRating(@Valid @NonNull @RequestBody Long studentId, Long foodId, Integer score) {
        RatingController rateService;
        ratingService.createRating(studentId, foodId, score);
    }

    @GetMapping(path = "{id}")
    public Rating getById(@PathVariable("id") Long id){
        return ratingService.getById(id);
    }
}
