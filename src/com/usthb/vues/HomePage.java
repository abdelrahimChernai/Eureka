package com.usthb.vues;

import java.awt.Color;

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
	
	public HomePage() {
		super(null, true);
		
		username = new JLabel("Log In");
		username.setForeground(Color.decode("#BB86FC"));
		username.setBounds(682, 93, 50, 25);
		username.addMouseListener(new AppControler());
		
		dontHaveAnAccount = new JLabel("Dont have an account?");
		dontHaveAnAccount.setForeground(Color.decode("#FFFFFF"));
		dontHaveAnAccount.setBounds(331, 509, 147, 25);
		
		createAccount = new JLabel("Creat one now!");
		createAccount.setForeground(Color.decode("#BB86FC"));
		createAccount.setBounds(356, 534, 98, 25);
		createAccount.addMouseListener(new AppControler());
		
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
		this.add(username);
		this.add(dontHaveAnAccount);
		this.add(createAccount);
		this.add(newGameButton);
		this.add(continueButton);
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username.setText(username);
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
