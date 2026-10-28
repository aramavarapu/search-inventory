package com.pluralsight;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product (4567, "10 2x4 (grade B", 9.99));
        inventory.add(new Product (1234, "Hammer", 19.49));
        inventory.add(new Product(2345, "Box of nails", 9.29));
        inventory.add(new Product(1224, "Gloves", 10.99));
        inventory.add(new Product(6767, "Tool Kit", 39.99));

        return inventory;

    }
}
