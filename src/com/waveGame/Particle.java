package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Particle extends GameObject{
	
		private Handler handler;
		
		Random r=new Random();
		
		private int red=r.nextInt(255);
		private int green=r.nextInt(255);
		private int blue=r.nextInt(255);
		
		private Color color;

		public Particle(int x, int y, ID id,Handler handler) {
			super(x, y, id);
			this.handler=handler;
			
			
			spdX=(r.nextInt(8- -8)+ -8);
			spdY=(r.nextInt(8- -8)+ -8);
			
		   color=new Color(red,green,blue);
			
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			x+=spdX;
			y+=spdY;
			
			
			if(y<=0 || y>=Game.h-32)  spdY*=-1;
			if(x<=0 || x>=Game.w-64)  spdX*=-1;
			
			handler.addObject(new BasicTrail(x,y,color,16,16,0.05f,ID.BasicTrail,handler));
			
		}

		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(color);
			g.fillRect(x,y,16,16);
			
		}

		@Override
		public Rectangle getBounds() {
			// TODO Auto-generated method stub
			return new Rectangle(x,y,16,16);
		}
}



