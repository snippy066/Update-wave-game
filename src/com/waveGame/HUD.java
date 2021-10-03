package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health=100;
	private int greenColor=255;
	
	public void tick() {
//		health--;
		
		health=Game.clamp(health, 0, 100);
		greenColor=Game.clamp(greenColor,0, 255);
		
		
		greenColor=health*2;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(3, 3, 200, 28);
		if(health>50) {
		g.setColor(new Color(0,greenColor,0));
		}
		else {
			g.setColor(new Color(greenColor+100,0,0));
		}
		g.fillRect(3,3, health*2, 28);
		g.setColor(Color.WHITE);
		g.drawRect(3, 3, 200, 28);
		
	}

}
