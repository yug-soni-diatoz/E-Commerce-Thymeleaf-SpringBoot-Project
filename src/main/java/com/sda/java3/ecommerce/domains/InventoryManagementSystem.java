package com.sda.java3.ecommerce.domains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagementSystem {

    // Inner class representing a Warehouse
    public class Warehouse {
        private String location;
        private Map<Product, Integer> inventory = new HashMap<>();

        public Warehouse(String location) {
            this.location = location;
        }

        public String getLocation() {
            return location;
        }

        public void addProduct(Product product, int quantity) {
            inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
        }

        public int getProductQuantity(Product product) {
            return inventory.getOrDefault(product, 0);
        }

        // Method to get warehouse details as JSON
        public String toJson() {
            StringBuilder inventoryJson = new StringBuilder();
            for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
                inventoryJson.append("{\n")
                             .append("  \"product\": ").append(entry.getKey().toJson()).append(",\n")
                             .append("  \"quantity\": ").append(entry.getValue()).append("\n")
                             .append("},\n");
            }

            return "{\n" +
                   "  \"location\": \"" + location + "\",\n" +
                   "  \"inventory\": [" + inventoryJson.toString() + "]\n" +
                   "}";
        }
    }

    // Inner class representing a Product
    public class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        // Method to get product details as JSON
        public String toJson() {
            return "{\n" +
                   "  \"name\": \"" + name + "\",\n" +
                   "  \"price\": " + price + "\n" +
                   "}";
        }
    }

    // Inner class representing an InventoryManager
    public class InventoryManager {
        public void transferProduct(Warehouse from, Warehouse to, Product product, int quantity) {
            if (from.getProductQuantity(product) >= quantity) {
                from.addProduct(product, -quantity);
                to.addProduct(product, quantity);
                System.out.println("Transferred " + quantity + " units of " + product.getName() + " from " + from.getLocation() + " to " + to.getLocation());
            } else {
                System.out.println("Insufficient stock in " + from.getLocation() + " to transfer " + quantity + " units of " + product.getName());
            }
        }
    }

    // Method to simulate the inventory management process
    public void run() {
        Product laptop = new Product("Laptop", 1200.0);
        Product smartphone = new Product("Smartphone", 800.0);

        Warehouse warehouse1 = new Warehouse("New York");
        Warehouse warehouse2 = new Warehouse("Los Angeles");

        warehouse1.addProduct(laptop, 100);
        warehouse1.addProduct(smartphone, 200);

        InventoryManager manager = new InventoryManager();
        manager.transferProduct(warehouse1, warehouse2, laptop, 50);
        manager.transferProduct(warehouse1, warehouse2, smartphone, 100);
    }
}
