package com.usthb.vues;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.usthb.controler.AppControler;

public class PopUp extends JDialog {
	private AppControler manager;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	private JButton closeButton;
	private JPanel baseFrame;
	private JPanel gameFinished;
	private JPanel notConnected;
	private JPanel noCurrentGame;
	private JPanel loseProgress;
	
	public PopUp(JFrame parent, Font font) { 
		super(parent, "test", true);
		
		manager = new AppControler();
		
		closeButton = new JButton("");
		
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setBounds(WIDTH - 46, 1, 45, 28);
		closeButton.setBackground(Color.decode("#E81123"));
		closeButton.addActionListener(new AppControler());
		
		setupBaseFrame();
		
		this.setUndecorated(true);
		this.setFont(font);
		this.setSize(500, 200);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.add(baseFrame);
	}
	
	private void displayPopUp(Point center) {
		this.setLocation(center.x + ((EurekaFrame.WIDTH - WIDTH) / 2), 
				center.y + ((EurekaFrame.HEIGHT - HEIGHT) / 2));
		this.setVisible(true);
	}

	private void setupBaseFrame() {
		baseFrame = new JPanel(null, true);
		baseFrame.setBackground(Color.decode("#000000"));
		baseFrame.setBounds(0, 0, WIDTH, HEIGHT);
	}
	
	
	
	public JPanel getBaseFrame() {
		return baseFrame;
	}

	public void displayGameFinished(Point center, boolean win, int score) {
		baseFrame.removeAll();
		
		gameFinished = new JPanel(null, true);
		
		JLabel message = new JLabel();
		message.setFont(this.getFont());
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel scoreJLabel = new JLabel(Integer.toString(score));
		scoreJLabel.setFont(this.getFont());
		scoreJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton leftButton = new JButton();
		leftButton.setFont(this.getFont());
		leftButton.setBorderPainted(false);
		leftButton.setFocusPainted(false);
		leftButton.setBounds(67, 95, 150, 40);
		leftButton.setBackground(Color.decode("#4BBA87"));
		leftButton.setForeground(Color.decode("#FFFFFF"));
		leftButton.addActionListener(manager);
		
		JButton HomePageButton = new JButton("Home Page");
		HomePageButton.setFont(this.getFont());
		HomePageButton.setBorderPainted(false);
		HomePageButton.setFocusPainted(false);
		HomePageButton.setBounds(283, 95, 150, 40);
		HomePageButton.setBackground(Color.decode("#BB86FC"));
		HomePageButton.setForeground(Color.decode("#FFFFFF"));
		HomePageButton.addActionListener(manager);
		
		if (win) {
			message.setText("You Win!");
			message.setForeground(Color.decode("#4BBA87"));
			message.setBounds((WIDTH - (message.getText().length() * 8)) / 2
					, 23
					, (message.getText().length() * 8)
					, 20);
			
			scoreJLabel.setForeground(Color.decode("#4BBA87"));
			scoreJLabel.setBounds((WIDTH - 64) / 2, 53, 64, 20);
			
			leftButton.setText("New Game");
		} else {
			message.setText("You Lost :(");
			message.setForeground(Color.decode("#E81123"));
			message.setBounds((WIDTH - (message.getText().length() * 8)) / 2
					, 23
					, (message.getText().length() * 8)
					, 20);
			
			scoreJLabel.setForeground(Color.decode("#E81123"));
			scoreJLabel.setBounds((WIDTH - 64) / 2, 53, 64, 20);
			
			leftButton.setText("Replay");
		}
		
		gameFinished.add(message);
		gameFinished.add(scoreJLabel);
		gameFinished.add(leftButton);
		gameFinished.add(HomePageButton);
		gameFinished.setBounds(0, 32, WIDTH, HEIGHT - 32);
		gameFinished.setBackground(Color.decode("#1A1919"));

		baseFrame.add(gameFinished);

		displayPopUp(center);
	}
		
	public void displayNotConnected(Point center) {
		baseFrame.removeAll();
		
		notConnected = new JPanel(null, true);

		JLabel message = new JLabel("You Are not Connected");
		message.setFont(this.getFont());
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.decode("#FFFFFF"));
		message.setBounds((WIDTH - (message.getText().length() * 8)) / 2
				, 23
				, (message.getText().length() * 8)
				, 20);

		JButton logInButton = new JButton("Log In");
		logInButton.setFont(this.getFont());
		logInButton.setBorderPainted(false);
		logInButton.setFocusPainted(false);
		logInButton.setBounds(67, 95, 150, 40);
		logInButton.setBackground(Color.decode("#4BBA87"));
		logInButton.setForeground(Color.decode("#FFFFFF"));
		logInButton.addActionListener(manager);

		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(this.getFont());
		createAccountButton.setBorderPainted(false);
		createAccountButton.setFocusPainted(false);
		createAccountButton.setBounds(283, 95, 150, 40);
		createAccountButton.setBackground(Color.decode("#BB86FC"));
		createAccountButton.setForeground(Color.decode("#FFFFFF"));
		createAccountButton.addActionListener(manager);



		notConnected.add(message);
		notConnected.add(createAccountButton);
		notConnected.add(logInButton);
		notConnected.setBounds(0, 32, WIDTH, HEIGHT - 32);
		notConnected.setBackground(Color.decode("#1A1919"));

		baseFrame.add(closeButton);
		baseFrame.add(notConnected);

		displayPopUp(center);
	}
	
	public void displayLoseProgress(Point center) {
		baseFrame.removeAll();
		
		loseProgress = new JPanel(null, true);

		JLabel message = new JLabel("You will lose your current game progress!");
		message.setFont(this.getFont());
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.decode("#FFFFFF"));
		message.setBounds((WIDTH - (message.getText().length() * 8)) / 2
				, 23
				, (message.getText().length() * 8)
				, 20);

		JButton newGameButton = new JButton("Cancel");
		newGameButton.setFont(this.getFont());
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBounds(67, 95, 150, 40);
		newGameButton.setBackground(Color.decode("#4BBA87"));
		newGameButton.setForeground(Color.decode("#FFFFFF"));
		newGameButton.addActionListener(manager);

		JButton cancelButton = new JButton("New Game");
		cancelButton.setFont(this.getFont());
		cancelButton.setBorderPainted(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setBounds(283, 95, 150, 40);
		cancelButton.setBackground(Color.decode("#BB86FC"));
		cancelButton.setForeground(Color.decode("#FFFFFF"));
		cancelButton.addActionListener(manager);



		loseProgress.add(message);
		loseProgress.add(newGameButton);
		loseProgress.add(cancelButton);
		loseProgress.setBounds(0, 32, WIDTH, HEIGHT - 32);
		loseProgress.setBackground(Color.decode("#1A1919"));

		baseFrame.add(closeButton);
		baseFrame.add(loseProgress);

		displayPopUp(center);
	}
	
	public void removePopUp() {
		this.setVisible(false);
		this.dispose();
	}
}
