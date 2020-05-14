package com.usthb.vues;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PopUp extends JDialog {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	
	public PopUp(JFrame parent) { 
		super(parent, "test", true);
		this.setUndecorated(true);
		this.setSize(500, 200);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
	}
	
	public void displayPopUp(Point point) {
		this.setLocation(point.x + ((EurekaFrame.WIDTH - WIDTH) / 2), 
				point.y + ((EurekaFrame.HEIGHT - HEIGHT) / 2));
		this.setVisible(true);
	}
	
	public void removePopUp() {
		this.setVisible(false);
		this.dispose();
	}
}
