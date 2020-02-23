package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Menu;
import com.example.Hackathon.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public Iterable<Menu> findAll() {
        return menuService.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<?> createMenu(@Valid @RequestBody Menu menu) {
        Menu newMenu = menuService.saveOrUpdateMenu(menu);
        return new ResponseEntity<Menu>(newMenu, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public Menu getById(@PathVariable("id") Long id){
        return menuService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMenu(@PathVariable("id") Long id) {menuService.deleteMenu(id);}

    @PutMapping(path = "{id}")
    public void updatingMenu(@PathVariable("id") Long id,@RequestBody Menu menuToUpdate) {
        menuService.updateMenu(id,menuToUpdate);
    }

    @GetMapping(path = "{/todaymenu}")
    public Menu todaymenu(@PathVariable("id") Long id){
        return menuService.getById(id);
    }
}