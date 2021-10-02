package com.waveGame;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;
	
	public Window(int width, int height, String title,gameMain game) {
		JFrame frm=new JFrame(title);
		
		frm.setPreferredSize(new Dimension(width,height));
		frm.setMaximumSize(new Dimension(width,height));
		frm.setMinimumSize(new Dimension(width,height));
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		frm.setLocationRelativeTo(null);
		frm.add(game);
		frm.setVisible(true);
		game.start();
		
	}
}
