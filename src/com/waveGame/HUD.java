package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health=100;
	private int greenColor=255;
	
	private int score=0;
	private int level=1;
	
	public void tick() {
//		health--;
		
		health=(int) Game.clamp(health, 0, 100);
		greenColor=(int) Game.clamp(greenColor,0, 255);
		
		
		greenColor=health*2;
		
		score++;
		
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
		
		g.drawString("Score :" +score ,500,10);
		g.drawString("Level :" +level ,650,10);
		
	}
	
	public void setScore(int score) {
		this.score=score;	
	}
	
	public int getScore() {
		return score;
	}
	
    public int getLevel() {
    	return level;
    }
    public void setLevel(int level) {
		this.level=level;
	}

}
