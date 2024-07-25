package org.example;

public class Product {
    private final double cost;
    private final int quantity;
    private final String name;

    public Product(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void totalCost() {
        double total = cost * quantity;
        System.out.println("Total cost is " + total);
    }

    public void printProduct() {
        System.out.println(name + " costs " + cost + " and " + quantity + " units were purchased");
    }

    public static void main(String[] args) {
        Product product = new Product("Gallon of gas", 4.0, 10);
        product.printProduct();
        product.totalCost();
    }
}

