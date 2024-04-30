package main;

import main.components.PlayGround;
import main.entities.Mouse;

public class AssetSetter {
	PlayGround pg;

	public AssetSetter(PlayGround pg) {
		this.pg = pg;
	}

	public void setNPC() {
		pg.npc[0] = new Mouse(pg);
		pg.npc[0].worldX = pg.tileSize * 13;
		pg.npc[0].worldY = pg.tileSize * 5;

	}
}
