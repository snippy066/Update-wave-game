package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	private Handler handler;

	public BasicEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		spdX=5;
		spdY=5;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=spdX;
		y+=spdY;
		
		
		if(y<=0 || y>=Game.h-32)  spdY*=-1;
		if(x<=0 || x>=Game.w-64)  spdX*=-1;
		
		handler.addObject(new BasicTrail(x,y,Color.red,16,16,0.01f,ID.BasicTrail,handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x,y,16,16);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}

}
