package com.example.Hackathon.Service;

import com.example.Hackathon.Models.Menu;
import com.example.Hackathon.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Iterable<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu getById(Long Id) {
        return menuRepository.getById(Id);
    }

    public Menu createMenu(Menu menu) {
        menuRepository.saveAndFlush(menu);
        return menu;
    }

    public Menu saveOrUpdateMenu(Menu menu) {
        return menuRepository.saveAndFlush(menu);
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
