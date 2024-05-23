package com.example.tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.example.components.PlayGround;

public class TileManager {
	PlayGround gp;
	public Tile[] tiles;
	public int mapTileNum[][];

	public TileManager(PlayGround gp) {
		this.gp = gp;

		tiles = new Tile[2];
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

		getTileImage();
		loadMap("/levels/level1.txt");

	}

	public void getTileImage() {
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tiles[0].collision = false;

			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tiles[1].collision = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void loadMap(String path) {
		try {

			InputStream is = getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
				String line = br.readLine();

				while (col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;

		while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
			int tileNum = mapTileNum[col][row];

			int screenX = col * gp.tileSize;
			int screenY = row * gp.tileSize;

			g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			col++;

			if (col == gp.maxScreenCol) {
				col = 0;
				row++;
			}
		}
	}
}
