package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		
		for(int i=0;i<handler.obj.size();i++) {
			if(handler.obj.get(i).getId()==ID.Player) {
				player=handler.obj.get(i);
			}
			
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=spdX;
		y+=spdY;
		
		
		float diffx=x-player.getX()-10;
		float diffy=y-player.getY()-10;
		
		float dist=(float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		spdX=(int) ((-1.0/dist)*diffx*2.5);
		spdY=(int)((-1.0/dist)*diffy*2.5);
		
		
//		if(y<=0 || y>=Game.h-32)  spdY*=-1;
//		if(x<=0 || x>=Game.w-64)  spdX*=-1;
		
		handler.addObject(new BasicTrail(x,y,Color.green,16,16,0.01f,ID.BasicTrail,handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(x,y,16,16);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}

}
