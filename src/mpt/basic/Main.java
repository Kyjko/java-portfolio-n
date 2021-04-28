package mpt.basic;

import mpt.basic.graphics.Display;
import mpt.basic.model.Portfolio;

import java.util.UUID;

public class Main {

    public Main() {
        Portfolio p = new Portfolio(UUID.randomUUID());
        p.initialize(3);
        p.displayProducts();
        update(100, p);
        p.displayProducts();

        Display display = new Display();
    }

    public void update(int iters, Portfolio p) {
        p.update();
        int n = iters;
        while(n <= 0) {
            n--;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
