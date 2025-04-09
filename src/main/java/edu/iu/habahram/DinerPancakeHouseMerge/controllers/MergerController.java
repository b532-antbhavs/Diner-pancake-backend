package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    private final DinerMenu dinerMenu;
    private final PancakeHouseMenu pancakeHouseMenu;

    public MergerController() {
        this.dinerMenu = new DinerMenu();
        this.pancakeHouseMenu = new PancakeHouseMenu();
    }

    @GetMapping
    public List<MenuItem> getMergedMenu() {
        // Convert DinerMenu array to List
        List<MenuItem> dinerItems = Arrays.asList(dinerMenu.getMenuItems());

        // Get PancakeHouseMenu items (already a List)
        List<MenuItem> pancakeItems = pancakeHouseMenu.getMenuItems();

        // Merge and sort menu items by name
        return Stream.concat(dinerItems.stream(), pancakeItems.stream())
                .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName())) // Sorting alphabetically
                .collect(Collectors.toList());
    }
}

