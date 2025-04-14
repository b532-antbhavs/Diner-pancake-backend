package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController() {
        this.mergerRepository = mergerRepository;;
    }


    public  ArrayList<MenuItem> getTheMenus() {
//        ArrayList<Menu> menus = new ArrayList<>();
//        menus.add(new DinerMenu());
//        menus.add(new PancakeHouseMenu());
//        menus.add(new CafeMenu());
//        return menus;
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        Iterator<Menu> menuIterator = mergerRepository.getTheMenus().iterator();
        while (menuIterator.hasNext()) {
            Menu menu = menuIterator.next();
            Iterator<MenuItem> iterator = menu.createIterator();
            while(iterator.hasNext()) {
                MenuItem menuItem = iterator.next();
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }
}

