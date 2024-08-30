package com.sda.java3.ecommerce.domains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ECommerceSystem {

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

    // Inner class representing a Customer
    public class Customer {
        private String name;
        private List<Order> orders = new ArrayList<>();

        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addOrder(Order order) {
            orders.add(order);
        }

        public List<Order> getOrders() {
            return orders;
        }

        // Method to get customer details as JSON
        public String toJson() {
            return "{\n" +
                   "  \"name\": \"" + name + "\",\n" +
                   "  \"orders\": " + orders.stream().map(Order::toJson).toList() + "\n" +
                   "}";
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

        // Method to get order details as JSON
        public String toJson() {
            StringBuilder itemsJson = new StringBuilder();
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                itemsJson.append("{\n")
                         .append("  \"product\": ").append(entry.getKey().toJson()).append(",\n")
                         .append("  \"quantity\": ").append(entry.getValue()).append("\n")
                         .append("},\n");
            }

            return "{\n" +
                   "  \"items\": [" + itemsJson.toString() + "],\n" +
                   "  \"total\": " + calculateTotal() + "\n" +
                   "}";
        }
    }

    // Inner class representing an OrderProcessor
    public class OrderProcessor {
        public void processOrder(Order order) {
            double totalAmount = order.calculateTotal();
            System.out.println("Processing order with total amount: " + totalAmount);
        }
    }

    // Inner class representing a PaymentProcessor
    public class PaymentProcessor {
        public boolean processPayment(Customer customer, double amount) {
            System.out.println("Processing payment of $" + amount + " for customer: " + customer.getName());
            return true;  // Simulating a successful payment
        }
    }

    // Inner class representing a NotificationService
    public class NotificationService {
        public void sendOrderConfirmation(Customer customer, Order order) {
            System.out.println("Sending order confirmation to customer: " + customer.getName());
            System.out.println("Order details: " + order.toJson());
        }
    }

    // Method to simulate the e-commerce process
    public void run() {
        Product laptop = new Product("Laptop", 1200.0);
        Product smartphone = new Product("Smartphone", 800.0);

        Customer customer = new Customer("John Doe");

        Order order = new Order();
        order.addItem(laptop, 1);
        order.addItem(smartphone, 2);

        customer.addOrder(order);

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(order);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        boolean paymentSuccess = paymentProcessor.processPayment(customer, order.calculateTotal());

        if (paymentSuccess) {
            NotificationService notificationService = new NotificationService();
            notificationService.sendOrderConfirmation(customer, order);
        }
    }
}
