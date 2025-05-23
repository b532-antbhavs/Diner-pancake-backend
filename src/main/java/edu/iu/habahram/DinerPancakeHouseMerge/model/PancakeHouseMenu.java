package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class PancakeHouseMenu extends Menu {
    public PancakeHouseMenu(String name, String description) {
        super(name, description);
        addDefaultItems();
    }

    private void addDefaultItems() {
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true, 2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false, 2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true, 3.49);
        addItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true, 3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItem.setMenuName(getName());
        add(menuItem);
    }
}