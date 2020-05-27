package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.usthb.controler.AppControler;

public class HomePage extends JPanel {
	private AppControler manager;
	private JLabel title;
	private JLabel username;
	private JLabel lvl;
	private JLabel dontHaveAnAccount;
	private JLabel createAccount;
	private JLabel about;
	private JLabel help;
	private JLabel helpSymbol;
	private JButton newGameButton;
	private JButton continueButton;
	private JButton leaderBoardButton;
	private JButton addThemeButton;
	
	public HomePage(Font font, Font titleFont) {
		super(null, true);
		
		manager = new AppControler();
		
		title = new JLabel("Welcome To Eureka");
		title.setFont(titleFont);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBounds(215, 125, 380, 50);
		
		username = new JLabel("Log In");
		username.setFont(font);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.decode("#BB86FC"));
		username.setBounds(682, 80, 48, 20);
		username.addMouseListener(manager);
		
		lvl = new JLabel("");
		Font temp = font.deriveFont(12f);
		lvl.setFont(temp);
		lvl.setHorizontalAlignment(SwingConstants.CENTER);
		lvl.setForeground(Color.decode("#BB86FC"));
		lvl.setBounds(682, 97, 48, 20);
		lvl.addMouseListener(manager);
		
		dontHaveAnAccount = new JLabel("Dont have an account?");
		dontHaveAnAccount.setFont(font);
		dontHaveAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		dontHaveAnAccount.setForeground(Color.decode("#FFFFFF"));
		dontHaveAnAccount.setBounds(331, 509, 168, 25);
		
		createAccount = new JLabel("Creat one now!");
		createAccount.setFont(font);
		createAccount.setHorizontalAlignment(SwingConstants.CENTER);
		createAccount.setForeground(Color.decode("#BB86FC"));
		createAccount.setBounds(356, 534, 112, 25);
		createAccount.addMouseListener(manager);
		
		about = new JLabel("About");
		about.setFont(font);
		about.setHorizontalAlignment(SwingConstants.CENTER);
		about.setForeground(Color.decode("#BB86FC"));
		about.setBounds(46, 527, 40, 20);
		about.addMouseListener(manager);
		
		help = new JLabel("Help");
		help.setFont(font);
		help.setHorizontalAlignment(SwingConstants.CENTER);
		help.setForeground(Color.decode("#BB86FC"));
		help.setBounds(720, 534, 32, 20);
		help.addMouseListener(manager);
		
		helpSymbol = new JLabel("?");
		temp = font.deriveFont(25f);
		helpSymbol.setFont(temp);
		helpSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		helpSymbol.setForeground(Color.decode("#BB86FC"));
		helpSymbol.setBounds(711, 489, 50, 50);
		helpSymbol.addMouseListener(manager);
		
		newGameButton = new JButton("New Game");
		newGameButton.setFont(font);
		newGameButton.setHorizontalAlignment(SwingConstants.CENTER);
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBounds(280, 226, 250, 45);
		newGameButton.setBackground(Color.decode("#BB86FC"));
		newGameButton.setForeground(Color.decode("#FFFFFF"));
		newGameButton.addActionListener(manager);
		
		continueButton = new JButton("Continue");
		continueButton.setFont(font);
		continueButton.setHorizontalAlignment(SwingConstants.CENTER);
		continueButton.setBorderPainted(false);
		continueButton.setFocusPainted(false);
		continueButton.setBounds(280, 294, 250, 45);
		continueButton.setBackground(Color.decode("#BB86FC"));
		continueButton.setForeground(Color.decode("#FFFFFF"));
		continueButton.addActionListener(manager);
		
		leaderBoardButton = new JButton("Leader Board");
		leaderBoardButton.setFont(font);
		leaderBoardButton.setHorizontalAlignment(SwingConstants.CENTER);
		leaderBoardButton.setBorderPainted(false);
		leaderBoardButton.setFocusPainted(false);
		leaderBoardButton.setBounds(305, 358, 200, 45);
		leaderBoardButton.setBackground(Color.decode("#BB86FC"));
		leaderBoardButton.setForeground(Color.decode("#FFFFFF"));
		leaderBoardButton.addActionListener(manager);
		
		addThemeButton = new JButton("Add themes");
		addThemeButton.setFont(font);
		addThemeButton.setHorizontalAlignment(SwingConstants.CENTER);
		addThemeButton.setBorderPainted(false);
		addThemeButton.setFocusPainted(false);
		addThemeButton.setBounds(305, 422, 200, 45);
		addThemeButton.setBackground(Color.decode("#BB86FC"));
		addThemeButton.setForeground(Color.decode("#FFFFFF"));
		addThemeButton.addActionListener(manager);
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(title);
		this.add(username);
		this.add(lvl);
		this.add(dontHaveAnAccount);
		this.add(createAccount);
		this.add(about);
		this.add(help);
		this.add(helpSymbol);
		this.add(newGameButton);
		this.add(continueButton);
		this.add(leaderBoardButton);
		this.add(addThemeButton);
	}

	public JLabel getUsername() {
		return username;
	}
	
	

	/**
	 * @param username
	 * @param lvl
	 */
	public void setPlayerText(String username, int lvl) {
		this.username.setText(username);
		this.lvl.setText("Level " + lvl);
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
