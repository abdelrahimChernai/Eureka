package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


import com.usthb.controler.AppControler;

 public class EurekaFrame extends JFrame {
	private JPanel baseFrame;
	private JPanel homePage;
	private JPanel connectionPage;
	private final int WIDTH = 810;
	private final int HEIGHT = 620;
	
	public EurekaFrame() {
		homePage = new HomePage();
		homePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		connectionPage = new ConnectionPage();
		connectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		setupBaseFrame();
		
		this.setTitle("Eureka");
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		this.setContentPane(baseFrame);
		this.setUndecorated(true);
	}
	
	private void setupBaseFrame() {
		JButton closeButton = new JButton("");
		
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setBounds(WIDTH - 46, 1, 45, 28);
		closeButton.setBackground(Color.decode("#e81123"));
		closeButton.addActionListener(new AppControler());
		
	
		baseFrame = new JPanel(null, true);
		baseFrame.setBackground(Color.decode("#000000"));
		baseFrame.setBounds(0, 0, WIDTH, HEIGHT);
		baseFrame.add(closeButton);
		baseFrame.add(homePage);
	}
	
	public JPanel getBaseFrame() {
		return baseFrame;
	}

	public ConnectionPage getConnectionPage() {
		return (ConnectionPage) connectionPage;
	}
	
	public HomePage getHomePage() {
		return (HomePage) homePage;
	}
	
	
}
