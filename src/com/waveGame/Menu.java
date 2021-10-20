package com.waveGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.waveGame.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r=new Random();
	
	public Menu(Game game,Handler handler) {
		this.game=game;
		this.handler=handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		
		
		if(game.gameState==STATE.Menu) {
			//play button
			if(mouseOver(mx,my,(game.w/2)-100, (game.h/2)-100,200, 35)) {
				game.gameState=STATE.Game;
				handler.addObject(new Player(game.w/2-32,game.h/2-32 ,ID.Player,handler));
				handler.addObject(new BasicEnemy(r.nextInt(game.w-50),r.nextInt(game.h-50),ID.BasicEnemy,handler));
				
			}
			
			//help
			if(mouseOver(mx,my,(game.w/2)-100, (game.h/2),200, 35)) {
				game.gameState=STATE.help;
			}
			
			//play quit
			if(mouseOver(mx,my,(game.w/2)-100, (game.h/2)+100,200, 35)) {
				System.exit(1);
			}
			
		}
		
			
		//back button
		if(game.gameState==STATE.help) {
			if(mouseOver(mx,my,(game.w/2)-100, (game.h/2)+100,200, 35)) {
				game.gameState=STATE.Menu;
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx,int my,int x,int y, int width,int height) {
		if(mx > x && mx < x+width) {
			if(my > y && my < y+height) return true;
			
			return false;
		}
		return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(game.gameState==STATE.Menu) {
			Font font=new Font("Arial",1,40);
			Font fnt=new Font("Arial",1,18);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Menu",(game.w/2)-50, 60);
		    g.drawLine((game.w/2)-100,80,(game.w/2)+100,80);
			
			g.setFont(fnt);
			g.drawString("Play",(game.w/2)-25,(game.h/2)-75);
			g.drawString("Help",(game.w/2)-25,(game.h/2)+25);
			g.drawString("Quit",(game.w/2)-25,(game.h/2)+125);
			
			
			g.setColor(Color.red);
			g.drawRect((game.w/2)-100, (game.h/2)-100,200, 35);
			g.drawRect((game.w/2)-100, (game.h/2),200, 35);
			g.drawRect((game.w/2)-100, (game.h/2)+100,200, 35);
			
		}
		
		else if(game.gameState==STATE.help) {
			Font font=new Font("Arial",1,40);
			Font fnt=new Font("Arial",1,18);
			Font fnt2=new Font("Arial",1,12);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Help",(game.w/2)-50, 60);
			g.drawLine((game.w/2)-100,80,(game.w/2)+100,80);
			
			g.setFont(fnt2);
			g.drawString("This is a wave game in this you can press Arrow key or W,S,A,D to move the player, in order to dodge the enemies",50,(game.h/2)-100);
			
			
			g.setFont(fnt);
			g.drawString("Back",(game.w/2)-25,(game.h/2)+125);
			g.drawRect((game.w/2)-100, (game.h/2)+100,200, 35);
		}
	}
}
