package com.example.Hackathon.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    public Long id;

    @NotBlank
    public String name;

    public String origin;

    public Boolean organic;

    public Boolean vegetarian;

    public Boolean glutenFree;

    public Boolean halal;

    public Boolean kosher;

    public Boolean seafood;


}
