package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health=100;
	private int greenColor=0;
	
	public void tick() {
//		health--;
		
		health=Game.clamp(health, 0, 100);
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(3, 3, 200, 28);
		g.setColor(new Color(75,greenColor,0));
		g.fillRect(3,3, health*2, 28);
		g.setColor(Color.WHITE);
		g.drawRect(3, 3, 200, 28);
		
	}

}
