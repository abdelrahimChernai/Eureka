package com.usthb.ui;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;

public class Button extends JButton {
	
	public Button(Rectangle bounds, Color color, String text) {
		EventManager manager = new EventManager();
		
		this.setBorderPainted(false);
		this.setBounds(bounds);
		this.setBackground(color);
		this.setText(text);
		this.setForeground(Color.decode("#FFFFFF")); 
		this.setFocusPainted(false);
		this.addActionListener(manager);

	}
}
