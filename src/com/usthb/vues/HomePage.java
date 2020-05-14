package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.usthb.controler.AppControler;

public class HomePage extends JPanel {
	private JLabel username;
	private JLabel dontHaveAnAccount;
	private JLabel createAccount;
	private JButton newGameButton;
	private JButton continueButton;
	
	public HomePage(Font font) {
		super(null, true);
		
		username = new JLabel("Log In");
		username.setFont(font);
		username.setForeground(Color.decode("#BB86FC"));
		username.setBounds(682, 93, 48, 20);
		username.addMouseListener(new AppControler());
		
		dontHaveAnAccount = new JLabel("Dont have an account?");
		dontHaveAnAccount.setFont(font);
		dontHaveAnAccount.setForeground(Color.decode("#FFFFFF"));
		dontHaveAnAccount.setBounds(331, 509, 168, 25);
		
		createAccount = new JLabel("Creat one now!");
		createAccount.setFont(font);
		createAccount.setForeground(Color.decode("#BB86FC"));
		createAccount.setBounds(356, 534, 112, 25);
		createAccount.addMouseListener(new AppControler());
		
		newGameButton = new JButton("New Game");
		newGameButton.setFont(font);
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBounds(280, 326, 250, 45);
		newGameButton.setBackground(Color.decode("#BB86FC"));
		newGameButton.setForeground(Color.decode("#FFFFFF"));
		newGameButton.addActionListener(new AppControler());
		
		continueButton = new JButton("Continue");
		continueButton.setFont(font);
		continueButton.setBorderPainted(false);
		continueButton.setFocusPainted(false);
		continueButton.setBounds(280, 394, 250, 45);
		continueButton.setBackground(Color.decode("#BB86FC"));
		continueButton.setForeground(Color.decode("#FFFFFF"));
		continueButton.addActionListener(new AppControler());
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(username);
		this.add(dontHaveAnAccount);
		this.add(createAccount);
		this.add(newGameButton);
		this.add(continueButton);
	}

	public JLabel getUsername() {
		return username;
	}
	
	

	public void disableConnection(String username) {
		this.username.setText(username);
		this.createAccount.setVisible(false);
		this.dontHaveAnAccount.setVisible(false);
	}

	public JLabel getCreateAccount() {
		return createAccount;
	}

	public void hideAccountCreation() {
		this.dontHaveAnAccount.setVisible(false);
		this.createAccount.setVisible(false);
		
		this.repaint();
	}
	
}
