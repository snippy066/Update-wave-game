package com.waveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class UpdatedEnemy extends GameObject{
	
		private Handler handler;

		public UpdatedEnemy(int x, int y, ID id,Handler handler) {
			super(x, y, id);
			this.handler=handler;
			
			spdX=3;
			spdY=8;
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			x+=spdX;
			y+=spdY;
			
			
			if(y<=0 || y>=Game.h-32)  spdY*=-1;
			if(x<=0 || x>=Game.w-64)  spdX*=-1;
			
			handler.addObject(new BasicTrail(x,y,Color.cyan,16,16,0.01f,ID.BasicTrail,handler));
			
		}

		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.cyan);
			g.fillRect(x,y,16,16);
			
		}

		@Override
		public Rectangle getBounds() {
			// TODO Auto-generated method stub
			return new Rectangle(x,y,16,16);
		}
}



