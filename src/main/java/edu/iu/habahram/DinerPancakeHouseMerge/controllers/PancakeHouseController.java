package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pancakehouse")
public class PancakeHouseController {
    PancakeHouseRepository repository;

    public PancakeHouseController(PancakeHouseRepository repository) {
        this.repository = repository;
    }

//    @GetMapping
//    public List<MenuItem> get() {
//        return repository.getTheMenu();
//    }

    @GetMapping
    public List<MenuItem> get() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();

        Iterator<MenuItem> iterator = pancakeHouseMenu.createIterator();

        List<MenuItem> menuItems = new ArrayList<>();

        while (iterator.hasNext()) {
            menuItems.add(iterator.next());
        }
        return menuItems;
    }
}
