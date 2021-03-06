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
        ratingService.createRating(studentId, foodId, score);
    }

    @GetMapping(path = "{id}")
    public Rating getById(@PathVariable("id") Long id){
        return ratingService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRating(@PathVariable("id") Long id) {ratingService.deleteRating(id);}

    @PutMapping(path = "{id}")
    public void updatingRating(@PathVariable("id") Long id,@RequestBody Rating ratingToUpdate) {
        ratingService.updateRating(id,ratingToUpdate);
    }
}