package com.usthb.vues;
import java.awt.Color;
import java.awt.Font;

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
import com.usthb.dessin.Potence;

public class GamePage extends JPanel {
	private AppControler manager = new AppControler();
	private JLabel back;
	private JLabel chansesLeft;
	private JLabel score;
	private JLabel username;
	private JTextPane question;
	private JLabel level;
	private JLabel currentAnswer;
	private JTextField playerInput;
	private JPanel hangemanPanel;
	private JButton confirmButton;
	
	public GamePage(String username, Potence hangman,Font font) {
		super(null, true);
		
		back = new JLabel("Back");
		back.setFont(font);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.decode("#BB86FC"));
		back.setBounds(60, 90, 32, 20);
		back.addMouseListener(manager);
		
		chansesLeft = new JLabel();
		chansesLeft.setFont(font);
		chansesLeft.setForeground(Color.decode("#FFFFFF"));
		chansesLeft.setBounds((310 - 168) / 2, 0, 168, 20);
		chansesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		hangman.setFont(font);
		hangman.setBounds(5, 30, 300, 280);
		hangman.setBackground(new Color(.09f, .09f, .09f, 0.9f));
		hangman.setForeground(Color.decode("#FFFFFF"));
		
		score = new JLabel("0");
		score.setFont(font);
		score.setForeground(Color.decode("#4BBA87"));
		score.setBounds((310 - 168) / 2, 319, 8, 20);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.username = new JLabel(username);
		this.username.setFont(font);
		this.username.setForeground(Color.decode("#BB86FC"));
		this.username.setBounds(682, 93, 50, 20);
		this.username.addMouseListener(manager);
		
		question = new JTextPane();
		question.setFont(font);
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
		level.setFont(font);
		level.setForeground(Color.decode("#FFFFFF"));
		level.setBounds((810 - 77) / 2, 77, 80, 20);
		level.setHorizontalAlignment(SwingConstants.CENTER);
		
		currentAnswer = new JLabel();
		currentAnswer.setFont(font);
		currentAnswer.setBounds(451, 253, 250, 45);
		currentAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		currentAnswer.setForeground(Color.decode("#FFFFFF"));
		currentAnswer.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1 ,true));
		
		playerInput = new JTextField();
		playerInput.setFont(font);
		playerInput.setBounds(451, 371, 250, 45);
		playerInput.setHorizontalAlignment(SwingConstants.CENTER);
		playerInput.setBackground(Color.decode("#1A1919"));	
		playerInput.setForeground(Color.decode("#FFFFFF"));
		playerInput.addKeyListener(manager);
		playerInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		hangemanPanel = new JPanel(null, true);
		hangemanPanel.setBackground(new Color(.09f, .09f, .09f, 0.9f));
		hangemanPanel.setBounds(40, 224, 310, 339);
		hangemanPanel.add(chansesLeft);
		hangemanPanel.add(score);
		hangemanPanel.add(hangman);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setFont(font);
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(451, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#326C52"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(manager);
		confirmButton.setEnabled(false);
		
		this.setBackground(Color.decode("#1A1919"));
		this.add(back);
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
		int width =  Integer.toString(score).length() * 9;
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

	public JPanel getHangemanPanel() {
		return hangemanPanel;
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
