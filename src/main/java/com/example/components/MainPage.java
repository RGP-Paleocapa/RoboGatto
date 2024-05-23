package com.example.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPage extends JPanel {

	public MainPage(BorderLayout bl) {
		super(bl);
		PlayGround pg = new PlayGround();
		pg.setFocusable(true);
		this.add(pg, BorderLayout.NORTH);
		pg.setupGame();
		pg.startGameThread();
		CodingPanel cp = new CodingPanel();
		cp.setFocusable(true);
		this.add(cp, BorderLayout.CENTER);
	}
}
