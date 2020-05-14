package com.usthb.vues;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.usthb.controler.AppControler;

public class PopUp extends JDialog {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	private JPanel baseFrame;
	
	public PopUp(JFrame parent) { 
		super(parent, "test", true);
		
		setupBaseFrame();
		
		this.setUndecorated(true);
		this.setSize(500, 200);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.add(baseFrame);
	}
	
	private void setupBaseFrame() {
		JButton closeButton = new JButton("");
		
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setBounds(WIDTH - 46, 1, 45, 28);
		closeButton.setBackground(Color.decode("#E81123"));
		closeButton.addActionListener(new AppControler());
		
		baseFrame = new JPanel(null, true);
		baseFrame.setBackground(Color.decode("#000000"));
		baseFrame.setBounds(0, 0, WIDTH, HEIGHT);
		baseFrame.add(closeButton);
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
