package com.waveGame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 7006633468047331596L;
	
	public static final int w=800;     //width
	public static final int h=w/12*9;	//height
	public static final String tit="Wave Game";	//title 
	
	private Thread thread;
	private boolean running=false;
	
	
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawner spawn;
	private Menu menu;
	
	public enum STATE{
		Menu,
		help,
		end,
		Game
	};
	
	public static STATE gameState=STATE.Menu;
	
	
	public Game() {
		handler=new Handler();
		hud=new HUD();
		
		menu=new Menu(this,handler,hud);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(w,h,tit,this);
		
		
		spawn=new Spawner(handler,hud);
		
		
		r=new Random();
		
		if(gameState==STATE.Game) {	
		handler.addObject(new Player(w/2-32,h/2-32 ,ID.Player,handler));
		handler.addObject(new BasicEnemy(r.nextInt(Game.w-50),r.nextInt(Game.h-50),ID.BasicEnemy,handler));
		}
		
		else {
			for(int i=0;i<15;i++) {
				handler.addObject(new Particle(r.nextInt(w),r.nextInt(h),ID.Particle,handler));
			}
		}
		
		
	}

	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
		
	}
	
	public synchronized void stop() {
		try {
			
			thread.join();
			running=false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void run() {
		 	this.requestFocus();
	        long lastTime = System.nanoTime();
	        double nsPerTick = 1000000000D / 64;
	        
	        int ticks = 0;
	        int frames = 0;
	        
	        long lastTimer = System.currentTimeMillis();
	        double delta = 0;
	        
	        while (running) {
	            long now = System.nanoTime();
	            delta += (now - lastTime) / nsPerTick;
	            lastTime = now;
	            boolean shouldRender = true;
	            
	            while (delta >= 1) {
	                ticks++;
	                tick();
	                delta --;
	                shouldRender = true;
	            }
	            
	            try {
	                Thread.sleep(2);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	            
	            if (shouldRender) {
	                frames++;
	                render();
	            }
	            
	            if (System.currentTimeMillis() - lastTimer >= 1000) {
	                lastTimer += 1000;
	                //System.out.println(ticks + " ticks, " + frames + " frames");
	                frames = 0;
	                ticks = 0;
	            }
	        }
	        stop();
	 }
	 
	 private void tick() {
		 handler.tick();
		 
		 if(gameState==STATE.Game) {
		 hud.tick();
		 spawn.tick();
		 
		 if(hud.health<=0) {
			 hud.health=100;
			 gameState=STATE.end;
			 handler.clearEnemy();
			 for(int i=0;i<15;i++) {
					handler.addObject(new Particle(r.nextInt(w),r.nextInt(h),ID.Particle,handler));
				}
			 
		 }
		 }
		 else if(gameState==STATE.Menu ||gameState==STATE.end) {
			 menu.tick();
		 }
		 
	
	 }
	 
	 private void render() {
		 BufferStrategy bs=this.getBufferStrategy();
		 if(bs==null) {
			 this.createBufferStrategy(3);
			 return;
		 }
		 
		 Graphics g=bs.getDrawGraphics();
		 
		g.setColor(Color.black);
		g.fillRect(0, 0, w, h);
		
		handler.render(g);
		
		if(gameState==STATE.Game) {
		hud.render(g);
		}
		else if(gameState==STATE.Menu || gameState==STATE.help||gameState==STATE.end) {
			 menu.render(g);
		 }
		 
		 g.dispose();
		 bs.show();
	 }
	 
	 
	 //clamp method to clamp player position
	 public static float clamp(float pos,float min,float max) {
		 if(pos>=max)
			 return pos=max;
		 else if(pos<=min)
			 return pos=min;
		 else
			 return pos;
	 }
	 
	public static void main(String[] args) {
		new Game();

	}

}
