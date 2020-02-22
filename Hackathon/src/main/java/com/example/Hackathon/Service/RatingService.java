package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Rating;
import com.example.Hackathon.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Iterable<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating getById(Long Id) {
        return ratingRepository.getById(Id);
    }

    public Rating createRating(Long studentId, Long foodId, Integer score) {
        Rating rating = new Rating().setStudentId(studentId).setFoodId(foodId).setRating(score);
        return rating;
    }

    public int deleteRating(Long Id) {
        ratingRepository.deleteById(Id);
        return 1;
    }

    public int updateRating(Long Id, Rating newRating) {
        ratingRepository.deleteById(Id);
        ratingRepository.saveAndFlush(newRating);
        return 1;
    }



}