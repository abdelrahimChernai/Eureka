package com.usthb.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	public Panel(Rectangle bounds, Color color, LinkedList<Component> components) {
		super(null, true);
		
		this.setBounds(bounds);
		this.setBackground(color);
		
		for (Component component : components) {
			this.add(component);
		}
	}
}
