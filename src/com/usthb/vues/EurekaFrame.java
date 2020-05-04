package com.usthb.vues;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.usthb.controler.AppControler;

 public class EurekaFrame extends JFrame {
	private JPanel baseFrame;
	private JPanel homePage;
	private JPanel connectionPage;
	private JPanel themeSelectionPage;
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
		closeButton.setBackground(Color.decode("#E81123"));
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

	public HomePage getHomePage() {
		return (HomePage) homePage;
	}
	
	public ConnectionPage getConnectionPage() {
		return (ConnectionPage) connectionPage;
	}

	public JPanel getThemeSelectionPage() {
		return themeSelectionPage;
	}

	public void setThemeSelectionPage(
			LinkedList<String> themes
			, String username) {

		this.themeSelectionPage = new ThemeSelectionPage(themes, username);
		this.themeSelectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
	}
	
	

	
	
	
	
}
