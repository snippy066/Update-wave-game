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
	
	public gameMain() {
		handler=new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		new Window(w,h,tit,this);
		
		hud=new HUD();
		
		r=new Random();
		
		handler.addObject(new Player(w/2-32,h/2-32 ,ID.Player,handler));
		
		handler.addObject(new BasicEnemy(r.nextInt(w),r.nextInt(h),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(w),r.nextInt(h),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(w),r.nextInt(h),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(w),r.nextInt(h),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(w),r.nextInt(h),ID.BasicEnemy,handler));
		
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
		 hud.tick();
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
		hud.render(g);
		 
		 g.dispose();
		 bs.show();
	 }
	 
	 
	 //clamp method to clamp player position
	 public static int clamp(int pos,int min,int max) {
		 if(pos>=max)
			 return pos=max;
		 else if(pos<=min)
			 return pos=min;
		 else
			 return pos;
	 }
	 
	public static void main(String[] args) {
		new gameMain();

	}

}
