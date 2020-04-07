package com.usthb.ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.LinkedList;


public class Window extends JFrame {
	public static final int WIDTH = 810;
	public static final int HEIGHT = 620;
	
	public Window(String title, Color backgroundColor, LinkedList<Panel> panels) {
		JPanel background = new JPanel(null, true);
		
		background.setBackground(backgroundColor);
		background.setBounds(0, 0, WIDTH, HEIGHT);
		background.add(Elements.CLOSE.getComponent());
		
		for (JPanel panel : panels) {
			background.add(panel);
		}
		
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.add(background);
	}
}
