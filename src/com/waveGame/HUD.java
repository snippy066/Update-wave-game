package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health=100;
	
	public void tick() {
//		health--;
		
		health=gameMain.clamp(health, 0, 100);
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(3, 3, 200, 28);
		g.setColor(Color.green);
		g.fillRect(3,3, health*2, 28);
		g.setColor(Color.WHITE);
		g.drawRect(3, 3, 200, 28);
		
	}

}
