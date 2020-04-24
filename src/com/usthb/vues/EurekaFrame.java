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
		setupHomePage();
		setupConnectionPage();
		
		
		
		
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
	
	private void setupHomePage() {
		JButton newGameButton = new JButton("New Game");
		JButton continueButton = new JButton("Continue");
		
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBounds(280, 326, 250, 45);
		newGameButton.setBackground(Color.decode("#BB86FC"));
		newGameButton.setForeground(Color.decode("#FFFFFF"));
		newGameButton.addActionListener(new AppControler());
		
		continueButton.setBorderPainted(false);
		continueButton.setFocusPainted(false);
		continueButton.setBounds(280, 394, 250, 45);
		continueButton.setBackground(Color.decode("#BB86FC"));
		continueButton.setForeground(Color.decode("#FFFFFF"));
		continueButton.addActionListener(new AppControler());
		
		homePage = new JPanel(null, true);
		homePage.setBackground(Color.decode("#1A1919"));
		homePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		homePage.add(newGameButton);
		homePage.add(continueButton);
	}
	
	private void setupConnectionPage() {
		JLabel usernameText = new JLabel("Username");
		JLabel passwordText = new JLabel("Password");
		JTextField usernameInput = new JTextField();
		JTextField passwordInput = new JTextField();
		JButton confirmButton = new JButton("Confirm");
		
		usernameText.setBounds(300, 214, 92, 27);
//		usernameText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameText.setForeground(Color.decode("#FFFFFF"));
		
		passwordText.setBounds(300, 303, 80, 27);
		passwordText.setForeground(Color.decode("#FFFFFF"));
		
		usernameInput.setBounds(280, 241, 250, 45);
//		usernameInput.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameInput.setBackground(Color.decode("#1A1919"));
		usernameInput.setForeground(Color.decode("#FFFFFF"));
		usernameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		passwordInput.setBounds(280, 330, 250, 45);
		passwordInput.setBackground(Color.decode("#1A1919"));
		passwordInput.setForeground(Color.decode("#FFFFFF"));
		passwordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(280, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#4BBA87"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(new AppControler());
		
		connectionPage = new JPanel(null, true);
		connectionPage.setBackground(Color.decode("#1A1919"));
		connectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		connectionPage.add(usernameText);
		connectionPage.add(usernameInput);
		connectionPage.add(passwordText);
		connectionPage.add(passwordInput);
		connectionPage.add(confirmButton);
	}

	public JPanel getBaseFrame() {
		return baseFrame;
	}

	public JPanel getConnectionPage() {
		return connectionPage;
	}
	
	public JPanel getHomePage() {
		return homePage;
	}
	
	
}
