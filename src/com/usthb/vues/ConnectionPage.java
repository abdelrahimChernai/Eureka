package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.usthb.controler.AppControler;

public class ConnectionPage extends JPanel {
	private AppControler manager = new AppControler();
	private JLabel back;
	private JLabel usernameText;
	private JLabel passwordText;
	private JLabel usernameError;
	private JLabel passwordError;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton confirmButton;
	
	public ConnectionPage(Font font) {
		super(null, true);
		
		back = new JLabel("Back");
		back.setFont(font);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.decode("#BB86FC"));
		back.setBounds(60, 90, 32, 20);
		back.addMouseListener(manager);
		
		usernameText = new JLabel("Username");
		usernameText.setFont(font);
		usernameText.setBounds(300, 184, 92, 27);
		usernameText.setForeground(Color.decode("#FFFFFF"));

		passwordText = new JLabel("Password");
		passwordText.setFont(font);
		passwordText.setBounds(300, 314, 80, 27);
		passwordText.setForeground(Color.decode("#FFFFFF"));
		
		usernameError = new JLabel();
		usernameError.setFont(font);
		usernameError.setBounds(353, 256, 111, 20);
		usernameError.setForeground(Color.decode("#E81123"));
		
		passwordError = new JLabel();
		passwordError.setFont(font);
		passwordError.setBounds(278, 386, 296, 20);
		passwordError.setForeground(Color.decode("#E81123"));
		
		usernameInput = new JTextField();
		usernameInput.setFont(font);
		usernameInput.setBounds(280, 211, 250, 45);
		usernameInput.setHorizontalAlignment(SwingConstants.CENTER);
		usernameInput.setBackground(Color.decode("#1A1919"));
		usernameInput.setForeground(Color.decode("#FFFFFF"));
		usernameInput.addKeyListener(manager);
		usernameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		passwordInput = new JPasswordField();
		passwordInput.setFont(font);
		passwordInput.setBounds(280, 341, 250, 45);
		passwordInput.setHorizontalAlignment(SwingConstants.CENTER);
		passwordInput.setBackground(Color.decode("#1A1919"));	
		passwordInput.setForeground(Color.decode("#FFFFFF"));
		passwordInput.addKeyListener(manager);
		passwordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));

		confirmButton = new JButton("Confirm");
		confirmButton.setFont(font);
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(280, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#4BBA87"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(manager);

		this.setBackground(Color.decode("#1A1919"));
		this.add(back);
		this.add(usernameText);
		this.add(usernameInput);
		this.add(usernameError);
		this.add(passwordText);
		this.add(passwordInput);
		this.add(passwordError);
		this.add(confirmButton);

	}

	public JTextField getUsernameInput() {
		return usernameInput;
	}

	public JTextField getPasswordInput() {
		return passwordInput;
	}

	public void setUsernameError(String errorMesseg) {
		int width = errorMesseg.length() * 8;
		usernameError.setBounds(((810 - width) / 2), 264, width, 20);
		usernameError.setText(errorMesseg);
		usernameError.setHorizontalAlignment(SwingConstants.CENTER);
		
		usernameInput.setText("");
		usernameInput.setBorder(
				new LineBorder(Color.decode("#E81123"), 1, true));
		
		passwordError.setText("");
		
		passwordInput.setText("");
		passwordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		this.repaint();
	}

	public void setPasswordError(String errorMesseg) {
		int width =  errorMesseg.length() * 8;
		passwordError.setBounds(((810 - width) / 2), 395, width, 20);
		passwordError.setText(errorMesseg);
		passwordError.setHorizontalAlignment(SwingConstants.CENTER);
		
		usernameError.setText("");
		usernameInput.setBorder(
				new LineBorder(Color.decode("#4BBA87"), 1, true));
		
		
		passwordInput.setText("");
		passwordInput.setBorder(
				new LineBorder(Color.decode("#E81123"), 1, true));
		
		this.repaint();
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}
	
	
	
	
}
