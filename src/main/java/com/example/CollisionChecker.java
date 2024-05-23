package com.example;

import com.example.components.PlayGround;
import com.example.entities.Entity;

public class CollisionChecker {
	PlayGround pg;

	public CollisionChecker(PlayGround pg) {
		this.pg = pg;
	}

	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

		int entityLeftCol = entityLeftWorldX / pg.tileSize;
		int entityRightCol = entityRightWorldX / pg.tileSize;
		int entityTopRow = entityTopWorldY / pg.tileSize;
		int entityBottomRow = entityBottomWorldY / pg.tileSize;

		int tileNum1, tileNum2;
		switch (entity.direction) {
			case "up":
				entityTopRow = (entityTopWorldY - entity.speed) / pg.tileSize;
				tileNum1 = pg.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = pg.tileM.mapTileNum[entityRightCol][entityTopRow];
				if (pg.tileM.tiles[tileNum1].collision || pg.tileM.tiles[tileNum2].collision) {
					entity.collisionOn = true;
				}
				break;
			case "down":
				entityBottomRow = (entityBottomWorldY + entity.speed) / pg.tileSize;
				tileNum1 = pg.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = pg.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if (pg.tileM.tiles[tileNum1].collision || pg.tileM.tiles[tileNum2].collision) {
					entity.collisionOn = true;
				}
				break;
			case "left":
				entityLeftCol = (entityLeftWorldX - entity.speed) / pg.tileSize;
				tileNum1 = pg.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = pg.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				if (pg.tileM.tiles[tileNum1].collision || pg.tileM.tiles[tileNum2].collision) {
					entity.collisionOn = true;
				}
				break;
			case "right":
				entityRightCol = (entityRightWorldX + entity.speed) / pg.tileSize;
				tileNum1 = pg.tileM.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = pg.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if (pg.tileM.tiles[tileNum1].collision || pg.tileM.tiles[tileNum2].collision) {
					entity.collisionOn = true;
				}
				break;
		}
	}

	// NPC OR MONSTER COLLISION
	public int checkEntity(Entity entity, Entity[] target) {
		int index = 999;

		for (int i = 0; i < target.length; i++) {
			if (target[i] != null) {
				// Get entity's solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;

				// Get the object's solid area
				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

				switch (entity.direction) {
					case "up":
						entity.solidArea.y -= entity.speed;
						if (entity.solidArea.intersects(target[i].solidArea)) {
							if (target[i].collisionOn) {
								entity.collisionOn = true;
								index = i;
							}

						}
						break;
					case "down":
						entity.solidArea.y += entity.speed;
						if (entity.solidArea.intersects(target[i].solidArea)) {
							if (target[i].collisionOn) {
								entity.collisionOn = true;
								index = i;
							}

						}
						break;
					case "left":
						entity.solidArea.x -= entity.speed;
						if (entity.solidArea.intersects(target[i].solidArea)) {
							if (target[i].collisionOn) {
								entity.collisionOn = true;
								index = i;
							}
						}
						break;
					case "right":
						entity.solidArea.x += entity.speed;
						if (entity.solidArea.intersects(target[i].solidArea)) {
							if (target[i].collisionOn) {
								entity.collisionOn = true;
								index = i;
							}

						}
						break;
				}
				entity.solidArea.x = entity.solidAreaX;
				entity.solidArea.y = entity.solidAreaY;
				target[i].solidArea.x = target[i].solidAreaX;
				target[i].solidArea.y = target[i].solidAreaY;
			}

		}

		return index;
	}

	public void checkCat(Entity entity) {
		// Get entity's solid area position
		entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y = entity.worldY + entity.solidArea.y;

		// Get the object's solid area
		pg.cat.solidArea.x = pg.cat.worldX + pg.cat.solidArea.x;
		pg.cat.solidArea.y = pg.cat.worldY + pg.cat.solidArea.y;

		switch (entity.direction) {
			case "up":
				entity.solidArea.y -= entity.speed;
				if (entity.solidArea.intersects(pg.cat.solidArea)) {
					if (pg.cat.collisionOn) {
						entity.collisionOn = true;

					}

				}
				break;
			case "down":
				entity.solidArea.y += entity.speed;
				if (entity.solidArea.intersects(pg.cat.solidArea)) {
					if (pg.cat.collisionOn) {
						entity.collisionOn = true;

					}

				}
				break;
			case "left":
				entity.solidArea.x -= entity.speed;
				if (entity.solidArea.intersects(pg.cat.solidArea)) {
					if (pg.cat.collisionOn) {
						entity.collisionOn = true;

					}
				}
				break;
			case "right":
				entity.solidArea.x += entity.speed;
				if (entity.solidArea.intersects(pg.cat.solidArea)) {
					if (pg.cat.collisionOn) {
						entity.collisionOn = true;

					}

				}
				break;
		}
		entity.solidArea.x = entity.solidAreaX;
		entity.solidArea.y = entity.solidAreaY;
		pg.cat.solidArea.x = pg.cat.solidAreaX;
		pg.cat.solidArea.y = pg.cat.solidAreaY;
	}

}
