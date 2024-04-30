package main.entities;

import java.util.Random;

import main.components.PlayGround;

public class Mouse extends Entity {

	public Mouse(PlayGround pg) {
		super(pg);
		direction = "down";
		speed = 1;
		setImage();
	}

	public void setImage() {
		up1 = setup("/res/npc/oldman_up_1.png");
		up2 = setup("/res/npc/oldman_up_2.png");
		down1 = setup("/res/npc/oldman_down_1.png");
		down2 = setup("/res/npc/oldman_down_2.png");
		left1 = setup("/res/npc/oldman_left_1.png");
		left2 = setup("/res/npc/oldman_left_2.png");
		right1 = setup("/res/npc/oldman_right_1.png");
		right2 = setup("/res/npc/oldman_right_2.png");

	}

	public void setAction() {

		actionLockCounter++;

		if (actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1;

			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75) {
				direction = "right";
			}
			actionLockCounter = 0;

		}

	}
}
