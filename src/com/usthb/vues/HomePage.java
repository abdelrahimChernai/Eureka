package com.usthb.vues;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.usthb.controler.AppControler;

public class HomePage extends JPanel {
	private JButton newGameButton;
	private JButton continueButton;
	
	public HomePage() {
		super(null, true);
		
		newGameButton = new JButton("New Game");
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBounds(280, 326, 250, 45);
		newGameButton.setBackground(Color.decode("#BB86FC"));
		newGameButton.setForeground(Color.decode("#FFFFFF"));
		newGameButton.addActionListener(new AppControler());
		
		continueButton = new JButton("Continue");
		continueButton.setBorderPainted(false);
		continueButton.setFocusPainted(false);
		continueButton.setBounds(280, 394, 250, 45);
		continueButton.setBackground(Color.decode("#BB86FC"));
		continueButton.setForeground(Color.decode("#FFFFFF"));
		continueButton.addActionListener(new AppControler());
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(newGameButton);
		this.add(continueButton);
	}
	
	
}
