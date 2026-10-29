package com.pluralsight;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        String command = "";

        while (!command.equals("5")) {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1 - List all products");
            System.out.println("2 - Lookup a product by its ID");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter the command: ");

            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("We carry the following inventory: ");
                    for (int i = 0; i < inventory.size(); i++) {
                        Product p = inventory.get(i);
                        System.out.printf("id: %d %s - Price: $%.2f%n",
                                p.getId(), p.getName(), p.getPrice());
                    }
                    break;
                case "2":
                    System.out.println("User picked: Lookup a product by it's ID");
                    break;
                case "3":
                    System.out.println("User picked: Find all products within a price range");
                    break;
                case "4":
                    System.out.println("User picked: Add a new product");
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
        scanner.close();
    }


    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);

                inventory.add(new Product(id, name, price));
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;

    }
}
