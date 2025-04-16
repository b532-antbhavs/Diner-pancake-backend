package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        //TODO
        ArrayList<MenuItem> res = new ArrayList<>();
        for(MenuComponent m : menuComponents) {
            MenuItem newItem = new MenuItem(m.getName(), m.getDescription(), m.isVegetarian(), m.getPrice());
            res.add(newItem);
        }
        return (MenuItem[]) res.stream().toArray();
    }
}
