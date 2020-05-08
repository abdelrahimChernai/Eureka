package com.usthb.vues;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.usthb.controler.AppControler;

public class GamePage extends JPanel {
	private AppControler manager = new AppControler();
	private JLabel chansesLeft;
	private JLabel score;
	private JLabel username;
	private JTextPane question;
	private JLabel level;
	private JLabel currentAnswer;
	private JTextField playerInput;
	private JPanel hangemanPanel;
	private JButton confirmButton;
	
	public GamePage(String username) {
		super(null, true);
		
		chansesLeft = new JLabel();
		chansesLeft.setForeground(Color.decode("#FFFFFF"));
		chansesLeft.setBounds((310 - 168) / 2, 0, 168, 20);
		chansesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		score = new JLabel("0");
		score.setForeground(Color.decode("#4BBA87"));
		score.setBounds((310 - 168) / 2, 319, 168, 20);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.username = new JLabel(username);
		this.username.setForeground(Color.decode("#BB86FC"));
		this.username.setBounds(682, 93, 50, 25);
		this.username.addMouseListener(manager);
		
		question = new JTextPane();
		StyledDocument questionStyle = question.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		question.setBounds((810 - 200) / 2, 122, 200, 40);
		question.setBackground(Color.decode("#1A1919"));
		question.setForeground(Color.decode("#FFFFFF"));
		question.setEditable(false);
		question.setFocusable(false);
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		questionStyle.setParagraphAttributes(
				0
				, questionStyle.getLength()
				, center
				, false);
		
		
		level = new JLabel();
		level.setForeground(Color.decode("#FFFFFF"));
		level.setBounds((810 - 77) / 2, 77, 80, 20);
		level.setHorizontalAlignment(SwingConstants.CENTER);
		
		currentAnswer = new JLabel();
		currentAnswer.setBounds(451, 253, 250, 45);
		currentAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		currentAnswer.setForeground(Color.decode("#FFFFFF"));
		currentAnswer.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1 ,true));
		
		playerInput = new JTextField();
		playerInput.setBounds(451, 371, 250, 45);
		playerInput.setHorizontalAlignment(SwingConstants.CENTER);
		playerInput.setBackground(Color.decode("#1A1919"));	
		playerInput.setForeground(Color.decode("#FFFFFF"));
		playerInput.addKeyListener(manager);
		playerInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		hangemanPanel = new JPanel(null, true);
		hangemanPanel.setBackground(Color.decode("#1A1919"));
		hangemanPanel.setBounds(40, 224, 310, 339);
		hangemanPanel.add(chansesLeft);
		hangemanPanel.add(score);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(451, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#326C52"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(manager);
		confirmButton.setEnabled(false);
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(this.username);
		this.add(question);
		this.add(level);
		this.add(currentAnswer);
		this.add(playerInput);
		this.add(hangemanPanel);
		this.add(confirmButton);
	}
	
	public void setChansesLeft(int chansesLeft) {
		this.chansesLeft.setText("You still have " + chansesLeft + " chances");
	}

	public void setScore(int score) {
		int width =  Integer.toString(score).length() * 7;
		int centerOnX = chansesLeft.getBounds().x
				+ (chansesLeft.getBounds().width / 2);
		
		this.score.setText("" + score);
		this.score.setBounds(centerOnX - (width / 2), 319, width, 20);
		
		this.repaint();
	}

	public void setUsername(String username) {
		this.username.setText(username);
	}
	
	public void setQuestion(String question) {
		this.question.setText(question);
	}

	public void setLevel(int level) {
		this.level.setText("Level " + level);
	}


	public String getCurrentAnswer() {
		return currentAnswer.getText();
	}

	public void setCurrentAnswer(String currentAnswer) {
		this.currentAnswer.setText(currentAnswer);
	}

	public JTextField getPlayerInput() {
		return playerInput;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}
	
	public void enableCofirmButton() {
		confirmButton.setBackground(Color.decode("#4BBA87"));
		confirmButton.setEnabled(true);
	}
	
	public void disableCofirmButton() {
		confirmButton.setBackground(Color.decode("#326C52"));
		confirmButton.setEnabled(false);
	}
	
	public void updatePlayerInputState(boolean correct) {
		if (correct) {
			playerInput.setText("");
			playerInput.setBorder(
					new LineBorder(Color.decode("#326C52"), 1, true));
		} else {
			playerInput.setText("");
			playerInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		}
	}
	
}
