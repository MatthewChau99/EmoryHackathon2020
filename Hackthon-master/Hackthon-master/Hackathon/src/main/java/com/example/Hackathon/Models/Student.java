package com.example.Hackathon.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    public Long Id;

    @NotBlank
    public String name;

    @NotBlank
    public String email;

    public Character gender;

    public Integer year;

    public String origin;
}
