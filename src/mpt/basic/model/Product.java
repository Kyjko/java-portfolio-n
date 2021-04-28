package mpt.basic.model;

import java.util.Random;

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

    public void setName(String name) {
        this.name = name;
    }

    public void updatePrice() {
        double logY = new Random().nextGaussian();
        price *= Math.pow(Math.E, logY);
    }

}
