package main.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.AssetSetter;
import main.CollisionChecker;
import main.KeyHandler;
import main.entities.Cat;
import main.entities.Entity;
import main.tiles.TileManager;

public class PlayGround extends JPanel implements Runnable {
	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 size
	final int scale = 3; // mult for size
	public final int tileSize = originalTileSize * scale; // 48x48 px
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 8;
	public final int screenWidth = tileSize * maxScreenCol; // 768 px
	public final int screenHeight = tileSize * maxScreenRow; // 384 px

	// FPS
	final int FPS = 60;

	// SYSTEM
	public TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	AssetSetter aSetter = new AssetSetter(this);

	// ENTITIES
	public Cat cat = new Cat(this, keyH);
	public Entity[] npc = new Entity[10];

	public PlayGround() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		addKeyListener(keyH);
		setFocusable(true);
	}

	public void setupGame() {
		aSetter.setNPC();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta > 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update() {
		cat.update();

		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].update();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// TILEMAP
		tileM.draw(g2);

		// CAT
		cat.draw(g2);

		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].draw(g2);
			}
		}

		g2.dispose();
	}

}
