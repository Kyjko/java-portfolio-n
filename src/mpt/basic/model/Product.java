package mpt.basic.model;

import java.util.Random;

public class Product {

    private final String name;
    private double price;
    private final double originalPrice;
    private final double volatility;

    public Product(String name, double price, double volatility) {
        this.name = name;
        this.price = price;
        this.originalPrice = price;
        this.volatility = volatility;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice() {
        double logY = new Random().nextGaussian() * getVolatility();
        price *= Math.pow(Math.E, logY);
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getVolatility() {
        return volatility;
    }
}
