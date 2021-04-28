package mpt.basic.model;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Portfolio {

    private final UUID id;

    private final List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public UUID getId() {
        return id;
    }

    public String getSaltString(int len) {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random r = new Random();
        while(salt.length() < len) {
            int idx = (int) (r.nextFloat() * CHARS.length());
            salt.append(CHARS.charAt(idx));
        }

        return salt.toString();
    }

    public void clearProducts() {
        products.clear();
    }

    public void initialize(int num) {
        clearProducts();
        for(int i = 0; i < num; i++) {
            String name = getSaltString(5);
            Product p = new Product(name, new Random().nextDouble());
            products.add(p);
        }
    }

    public void update() {
        products.forEach(Product::updatePrice);
    }

    public void displayProducts() {
        PrintStream out = null;
        out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        PrintStream finalOut = out;
        finalOut.println("=== Products ===");
        products.forEach(p -> {
            finalOut.println(p.getName() + " - " + p.getPrice());
        });
    }

    public Portfolio(final UUID id) {
        this.id = id;
        products = new ArrayList<>();
    }
}
