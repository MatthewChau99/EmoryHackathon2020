package com.example.Hackathon.Controller;

import com.example.Hackathon.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        rateService.createRating(studentId, foodId, score);
    }

    @GetMapping(path = "{id}")
    public Person getById(@PathVariable("id") Long id){
        return foodService.getById(id)
                .orElse(null);
    }
}
