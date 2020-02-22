package com.example.Hackathon.Repository;

import com.example.Hackathon.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
    Menu getById(Long id);
}
