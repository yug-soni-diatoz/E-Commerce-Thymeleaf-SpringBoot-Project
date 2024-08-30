package com.sda.java3.ecommerce.domains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessingSystem {

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
    }

    // Inner class representing an Order
    public class Order {
        private Map<Product, Integer> items = new HashMap<>();

        public void addItem(Product product, int quantity) {
            items.put(product, quantity);
        }

        public double calculateTotal() {
            double total = 0;
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                total += entry.getKey().getPrice() * entry.getValue();
            }
            return total;
        }
    }

    // Inner class representing an OrderProcessor
    public class OrderProcessor {
        public void processOrder(Order order) {
            double totalAmount = order.calculateTotal();
            System.out.println("Processing order with total amount: " + totalAmount);
            // Additional logic for processing the order could go here
        }
    }

    // Method to simulate the order processing
    public void run() {
        Product product1 = new Product("Laptop", 1200.0);
        Product product2 = new Product("Smartphone", 800.0);

        Order order = new Order();
        order.addItem(product1, 2);
        order.addItem(product2, 3);

        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);
    }
}
