package com.example.Hackathon.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.awt.*;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank
    public String name;

    public String origin;

    public Boolean organic;

//    public Boolean vegetarian;
//
//    public Boolean glutenFree;
//
//    public Boolean halal;
//
//    public Boolean kosher;
//
//    public Boolean seafood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean getOrganic() {
        return organic;
    }

    public void setOrganic(Boolean organic) {
        this.organic = organic;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getHalal() {
        return halal;
    }

    public void setHalal(Boolean halal) {
        this.halal = halal;
    }

    public Boolean getKosher() {
        return kosher;
    }

    public void setKosher(Boolean kosher) {
        this.kosher = kosher;
    }

    public Boolean getSeafood() {
        return seafood;
    }

    public void setSeafood(Boolean seafood) {
        this.seafood = seafood;
    }
}