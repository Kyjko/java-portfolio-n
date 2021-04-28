package mpt.basic.graphics;

import mpt.basic.model.Portfolio;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Display extends Canvas {

    private boolean quit;
    private final int w, h;
    private JFrame f;
    private final Portfolio portfolio;

    public Display(Portfolio p) {
        this.portfolio = p;
        f = new JFrame("Portfolio");
        this.w = 640;
        this.h = 640;
        Dimension dim = new Dimension(w, h);
        f.setSize(dim);
        f.setResizable(true);
        f.setVisible(true);
        f.add(this);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quit = true;
                f.dispose();
            }
        });

        eventLoop();
    }

    private void eventLoop() {
        while(!quit) {
            render();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Colors.backgroundColor);
        g.fillRect(0, 0, w, h);

        portfolio.getProducts().forEach(p -> {
            g.setColor(Colors.chartColor);
        });

        g.dispose();
        bs.show();
    }
}
