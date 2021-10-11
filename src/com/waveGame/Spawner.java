package com.waveGame;

import java.util.Random;

public class Spawner  {

   private Handler handler;
   private HUD hud;
   private Random r=new Random();
   
   private int scoreKeep=0;
   private int scoreLevel=300;
   
   public Spawner(Handler handler,HUD hud) {
	   this.handler=handler;
	   this.hud=hud;
	   
   }
   
   public void tick() {
	    scoreKeep++;
	    
	    if(scoreKeep>=scoreLevel) {
	    	scoreKeep=0;
	    	scoreLevel+=100;
	    	int level=hud.getLevel()+1;
	    	hud.setLevel(level);
	    	if(level%2==0)
	    	handler.addObject(new BasicEnemy(r.nextInt(Game.w-50),r.nextInt(Game.h-50),ID.BasicEnemy,handler));
//	    	else if(level%3==0)
//	    		handler.addObject(new UpdatedEnemy(r.nextInt(Game.w-50),r.nextInt(Game.h-50),ID.SmartEnemy,handler));
	    	else
	    		handler.addObject(new SmartEnemy(r.nextInt(Game.w-50),r.nextInt(Game.h-50),ID.SmartEnemy,handler));
	    }
   }
}
