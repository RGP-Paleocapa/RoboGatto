package main.entities;

import java.awt.Rectangle;

import main.KeyHandler;
import main.components.PlayGround;

public class Cat extends Entity {
	KeyHandler keyH;

	public Cat(PlayGround pg, KeyHandler keyH) {
		super(pg);
		this.keyH = keyH;

		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 16;
		solidAreaX = solidArea.x;
		solidAreaY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;

		setDefaultValues();
		setImage();
	}

	public void setDefaultValues() {
		worldX = pg.tileSize * 1;
		worldY = pg.tileSize * 1;
		speed = 2;
		direction = "down";
	}

	public void setImage() {
		up1 = setup("/res/characters/boy_up_1.png");
		up2 = setup("/res/characters/boy_up_2.png");
		down1 = setup("/res/characters/boy_down_1.png");
		down2 = setup("/res/characters/boy_down_2.png");
		left1 = setup("/res/characters/boy_left_1.png");
		left2 = setup("/res/characters/boy_left_2.png");
		right1 = setup("/res/characters/boy_right_1.png");
		right2 = setup("/res/characters/boy_right_2.png");

	}

	public void update() {
		if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
			if (keyH.upPressed) {
				direction = "up";

			} else if (keyH.downPressed) {
				direction = "down";

			} else if (keyH.leftPressed) {
				direction = "left";

			} else if (keyH.rightPressed) {
				direction = "right";

			}

			// CHECK TILE COLLISION
			collisionOn = false;
			pg.cChecker.checkTile(this);

			int npcIndex = pg.cChecker.checkEntity(this, pg.npc);
			interact(npcIndex);
			// IF COLLISION IS FALSE, CAT CAN MOVE
			if (!collisionOn) {
				switch (direction) {
					case "up":
						worldY -= speed;
						break;
					case "down":
						worldY += speed;
						break;
					case "left":
						worldX -= speed;
						break;
					case "right":
						worldX += speed;
						break;
				}
			}
			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void interact(int index) {
		if (index != 999) {

		}
	}
}
