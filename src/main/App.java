package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import main.components.MainPage;

public class App {

    public static void main(String[] args) {
        JFrame window = new JFrame("Tom and Jerry");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        MainPage main = new MainPage(new BorderLayout());

        window.add(main);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}