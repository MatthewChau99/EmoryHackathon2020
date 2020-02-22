package com.example.Hackathon.Repository;

import com.example.Hackathon.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating getById(Long Id);
}
