package com.pluralsight;
import java.util.ArrayList;
import java.io.*;
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

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            while ((input = bufReader.readLine()) !=null) {
                String[] tokens = input.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name =tokens[2];
                double price = Double.parseDouble(tokens[2]);

                inventory.add(new Product(id, name, price));
            }
            bufReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;

    }
}
