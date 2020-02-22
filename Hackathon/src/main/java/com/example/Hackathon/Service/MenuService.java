package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Menu;
import com.example.Hackathon.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Iterable<Menu> findAll() {
        return MenuRepository.findAll();
    }

    public Menu getById(Long Id) {
        return MenuRepository.getById(Id);
    }

    public Menu createMenu(Menu menu) {
        menuRepository.saveAndFlush(menu);
        return menu;
    }

    public Menu saveOrUpdateMenu(Menu menu) {
        return MenuRepository.saveAndFlush(menu);
    }

    public int deleteMenu(Long Id){
        menuRepository.deleteById(Id);
        return 1;
    }

    public int updateMenu(Long Id, Menu newMenu) {
        menuRepository.deleteById(Id);
        menuRepository.saveAndFlush(newMenu);
        return 1;
    }
}
