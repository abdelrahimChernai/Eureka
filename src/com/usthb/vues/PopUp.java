package com.usthb.vues;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
	private JPanel about;
	private JPanel help;
	
	
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

	public JPanel getGameFinished() {
		return gameFinished;
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
	
	public void displayNoCurrentGame(Point center) {
		baseFrame.removeAll();
		
		noCurrentGame = new JPanel(null, true);

		JLabel message = new JLabel("You have no game in progress");
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



		noCurrentGame.add(message);
		noCurrentGame.add(newGameButton);
		noCurrentGame.add(cancelButton);
		noCurrentGame.setBounds(0, 32, WIDTH, HEIGHT - 32);
		noCurrentGame.setBackground(Color.decode("#1A1919"));

		baseFrame.add(closeButton);
		baseFrame.add(noCurrentGame);

		displayPopUp(center);
	}
	
	public void displayAbout(Point center) {
		baseFrame.removeAll();
		
		this.setSize(WIDTH, 260);
		baseFrame.setSize(WIDTH, 260);
		
		about = new JPanel(null, true);

		JLabel aboutEureka = new JLabel("About Eureka:");
		aboutEureka.setFont(this.getFont());
		aboutEureka.setHorizontalAlignment(SwingConstants.CENTER);
		aboutEureka.setForeground(Color.decode("#FFFFFF"));
		aboutEureka.setBounds((WIDTH - (aboutEureka.getText().length() * 8)) / 2
				, 23
				, aboutEureka.getText().length() * 8
				, 20);
		
		JLabel authors =
				new JLabel("By Abdelraim Chernai and Yasmine Bouamra");
		authors.setFont(this.getFont());
		authors.setHorizontalAlignment(SwingConstants.CENTER);
		authors.setForeground(Color.decode("#FFFFFF"));
		authors.setBounds((WIDTH - (authors.getText().length() * 7)) / 2
				, 72
				, authors.getText().length() * 7
				, 20);
		
		JLabel version =
				new JLabel("Version 1.2");
		version.setFont(this.getFont());
		version.setHorizontalAlignment(SwingConstants.CENTER);
		version.setForeground(Color.decode("#FFFFFF"));
		version.setBounds(authors.getX()
				, 108
				, version.getText().length() * 8
				, 20);

		JLabel date =
				new JLabel("May 21  2020");
		date.setFont(this.getFont());
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setForeground(Color.decode("#FFFFFF"));
		date.setBounds((authors.getX() + authors.getWidth())
						- (date.getText().length() * 8) 
				, 108
				, date.getText().length() * 8
				, 20);

		JButton okayButton = new JButton("Okay");
		okayButton.setFont(this.getFont());
		okayButton.setBorderPainted(false);
		okayButton.setFocusPainted(false);
		okayButton.setBounds(175, 156, 150, 40);
		okayButton.setBackground(Color.decode("#4BBA87"));
		okayButton.setForeground(Color.decode("#FFFFFF"));
		okayButton.addActionListener(manager);

		about.add(aboutEureka);
		about.add(authors);
		about.add(version);
		about.add(date);
		about.add(okayButton);
		about.setBounds(0, 32, WIDTH, 228);
		about.setBackground(Color.decode("#1A1919"));

		baseFrame.add(closeButton);
		baseFrame.add(about);

		displayPopUp(center);
	}
	
	public void displayHelp(Point center) {
		baseFrame.removeAll();
		
		this.setSize(WIDTH, 350);
		baseFrame.setSize(WIDTH, 350);
		
		help = new JPanel(null, true);

		JLabel aboutEureka = new JLabel("Game Rules:");
		aboutEureka.setFont(this.getFont());
		aboutEureka.setHorizontalAlignment(SwingConstants.CENTER);
		aboutEureka.setForeground(Color.decode("#FFFFFF"));
		aboutEureka.setBounds((WIDTH - (aboutEureka.getText().length() * 8)) / 2
				, 23
				, aboutEureka.getText().length() * 8
				, 20);
		
		JTextPane rules = new JTextPane();
		rules.setFont(this.getFont());
		StyledDocument rulesStyle = rules.getStyledDocument();
		SimpleAttributeSet centered = new SimpleAttributeSet();
		rules.setBounds(37, 54, 427, 180);
		rules.setBackground(Color.decode("#1A1919"));
		rules.setForeground(Color.decode("#FFFFFF"));
		rules.setEditable(false);
		rules.setFocusable(false);
		StyleConstants.setAlignment(centered, StyleConstants.ALIGN_JUSTIFIED);
		rulesStyle.setParagraphAttributes(
				0
				, rulesStyle.getLength()
				, centered
				, false);
		rules.setText("-\tEureka est un jeu éducatif qui se base sur le"
				+ "principe du Pendu.\n"
				+ "-\tQuand vous commencez une partie, une question vous sera"
				+ "posé. Pour gagner, vous devez entrer la réponse caractère"
				+ "par caractère.\n"
				+ "-\tDurant une partie, vous pourrez avoir jusqu'à 8 essais"
				+ "pour deviner de quels lettres la réponse est composée.\n"
				+ "-\tLe nombre de points gagnés durant la partie dépend du"
				+ "niveau de difficulté.\n"
				+ "-\tChaque partie gagnée vous fait passer au niveau suivant."
				);
		
		JButton okayButton = new JButton("Okay");
		okayButton.setFont(this.getFont());
		okayButton.setBorderPainted(false);
		okayButton.setFocusPainted(false);
		okayButton.setBounds(175, 246, 150, 40);
		okayButton.setBackground(Color.decode("#4BBA87"));
		okayButton.setForeground(Color.decode("#FFFFFF"));
		okayButton.addActionListener(manager);

		help.add(aboutEureka);
		help.add(okayButton);
		help.add(rules);
		help.setBounds(0, 32, WIDTH, 328);
		help.setBackground(Color.decode("#1A1919"));

		baseFrame.add(closeButton);
		baseFrame.add(help);

		displayPopUp(center);
	}
	
	public void removePopUp() {
		this.setVisible(false);
		this.dispose();
		this.setSize(WIDTH, HEIGHT);
		baseFrame.setSize(WIDTH, HEIGHT - 32);
	}
}
