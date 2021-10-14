package com.waveGame;


import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> obj=new LinkedList<GameObject>();
    
    public void tick() {
    	
    	for(int i=0;i<obj.size();i++) {
    		GameObject temp=obj.get(i);
    		
    		temp.tick();
    	}
    	
    }
    
    public void render(Graphics g) {
    	
    	for(int i=0;i<obj.size();i++) {
    		GameObject temp=obj.get(i);
    		
    		temp.render(g);
    	}
    }
    
    public void clearEnemy() {
    	for(int i=0;i<obj.size();i++) {
    		GameObject temp=obj.get(i);
    		
    		if(temp.getId()==ID.Player) {
    			obj.clear();
    			addObject(new Player(temp.getX(),temp.getY(),ID.Player,this));
    		}
    	}
    }
    
    
    public void addObject(GameObject object) {
    	this.obj.add(object);
    }
    
    public void removeObject(GameObject object) {
    	this.obj.remove(object);
    }
}
