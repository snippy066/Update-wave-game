package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject{
	private Handler handler;
	private int timer=80;
	private int timer2=50;
	
	Random r=new Random();

	public BossEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		spdX=0;
		spdY=2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=spdX;
		y+=spdY;
		
		if(timer<=0) {
			spdY=0;
			timer2--;
		}
		else timer--;
		
		if(timer2<=0 ) {
			if(spdX==0)
				spdX=3;
			
			if(spdX>0) spdX+=0.005f;
			else if(spdX<0) spdX-=0.005f;
			
			spdX=Game.clamp(spdX,-10,10);
			
			int spawn=r.nextInt(10);
			if(spawn==0) handler.addObject(new EnemyBullets(x+48,y+66,ID.BasicEnemy,handler) );
			
		}
		
		if(x<=0|| x>=Game.w-108) spdX*=-1;
		
		
//		if(y<=0 || y>=Game.h-32)  spdY*=-1;
//		if(x<=0 || x>=Game.w-64)  spdX*=-1;
		
		//handler.addObject(new BasicTrail(x,y,Color.red,96,96,0.01f,ID.BasicTrail,handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x,y,96,96);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,96,96);
	}

}
