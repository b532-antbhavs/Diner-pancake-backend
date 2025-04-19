package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class MergerRepository {
    private final MenuComponent allMenus;

    public MergerRepository() {
        allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
    }

    // Existing method
    public List<MenuItemRecord> getTheMenuItems() {
        return filterMenuItems(component -> true);
    }

    public List<MenuItemRecord> getVegetarianItems() {
        return filterMenuItems(MenuComponent::isVegetarian);
    }

    public List<MenuItemRecord> getBreakfastItems() {
        return filterMenuItems(component ->
                component instanceof MenuItem &&
                        "PANCAKE HOUSE MENU".equals(((MenuItem) component).getMenuName()));
    }

    public List<MenuItemRecord> getLunchItems() {
        return filterMenuItems(component ->
                component instanceof MenuItem &&
                        "DINER MENU".equals(((MenuItem) component).getMenuName()));
    }

    public List<MenuItemRecord> getDinnerItems() {
        return filterMenuItems(component ->
                component instanceof MenuItem &&
                        "CAFE MENU".equals(((MenuItem) component).getMenuName()));
    }

    private List<MenuItemRecord> filterMenuItems(Predicate<MenuComponent> filter) {
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem && filter.test(component)) {
                MenuItem item = (MenuItem) component;
                records.add(new MenuItemRecord(
                        item.getName(),
                        item.getDescription(),
                        item.isVegetarian(),
                        item.getPrice()
                ));
            }
        }
        return records;
    }

    public void signUp(String username, String password, String email) {
        try {
            Path path = Paths.get("data");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Path file = Paths.get("data/customers.txt");
            String customerData = String.format("%s,%s,%s%n", username, password, email);
            Files.write(file, customerData.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save customer data", e);
        }
    }
}