package mpt.basic.model;

import java.util.Random;

public class Product {

    private String name;
    private double price;
    private double originalPrice;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.originalPrice = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice() {
        double logY = new Random().nextGaussian();
        price *= Math.pow(Math.E, logY);
    }

    public double getOriginalPrice() {
        return originalPrice;
    }
}
