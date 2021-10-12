package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBullets extends GameObject{
	private Handler handler;
	Random r=new Random();

	public EnemyBullets(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		spdX=(r.nextInt(5+6)-6);
		spdY=5;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=spdX;
		y+=spdY;
		
		
//		if(y<=0 || y>=Game.h-32)  spdY*=-1;
//		if(x<=0 || x>=Game.w-64)  spdX*=-1;
		
		if(y>=Game.h) handler.removeObject(this);
		
		handler.addObject(new BasicTrail(x,y,Color.yellow,16,16,0.05f,ID.BasicTrail,handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect(x,y,16,16);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}

}
