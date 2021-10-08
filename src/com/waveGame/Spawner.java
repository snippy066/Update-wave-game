package com.waveGame;

public class Spawner  {

   private Handler handler;
   private HUD hud;
   
   private int scoreKeep=0;
   private int scoreLevel=500;
   
   public Spawner(Handler handler,HUD hud) {
	   this.handler=handler;
	   this.hud=hud;
	   
   }
   
   public void tick() {
	    scoreKeep++;
	    
	    if(scoreKeep>=scoreLevel) {
	    	scoreKeep=0;
	    	scoreLevel+=200;
	    	hud.setLevel(hud.getLevel()+1);
	    	System.out.println(hud.getLevel());
	    }
   }
}
