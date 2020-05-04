package com.usthb.vues;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.usthb.controler.AppControler;

public class ConnectionPage extends JPanel {
	private JLabel usernameText;
	private JLabel passwordText;
	private JLabel usernameError;
	private JLabel passwordError;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton confirmButton;
	
	public ConnectionPage() {
		super(null, true);
		
		usernameText = new JLabel("Username");
		usernameText.setBounds(300, 184, 92, 27);
		//	usernameText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameText.setForeground(Color.decode("#FFFFFF"));

		passwordText = new JLabel("Password");
		passwordText.setBounds(300, 314, 80, 27);
		passwordText.setForeground(Color.decode("#FFFFFF"));
		
		usernameError = new JLabel();
		usernameError.setBounds(353, 264, 111, 20);
		usernameError.setForeground(Color.decode("#E81123"));
		
		passwordError = new JLabel();
		passwordError.setBounds(278, 395, 296, 20);
		passwordError.setForeground(Color.decode("#E81123"));
		
		usernameInput = new JTextField();
		usernameInput.setBounds(280, 211, 250, 45);
		usernameInput.setHorizontalAlignment(SwingConstants.CENTER);
		//	usernameInput.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameInput.setBackground(Color.decode("#1A1919"));
		usernameInput.setForeground(Color.decode("#FFFFFF"));
		usernameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(280, 341, 250, 45);
		passwordInput.setHorizontalAlignment(SwingConstants.CENTER);
		passwordInput.setBackground(Color.decode("#1A1919"));	
		passwordInput.setForeground(Color.decode("#FFFFFF"));
		passwordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));

		confirmButton = new JButton("Confirm");
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(280, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#4BBA87"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(new AppControler());

		this.setBackground(Color.decode("#1A1919"));
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
		usernameError.setText(errorMesseg);
		
		usernameInput.setText("");
		usernameInput.setBorder(
				new LineBorder(Color.decode("#E81123"), 1, true));
		
		passwordInput.setText("");
		passwordInput.setBorder(
				new LineBorder(Color.decode("#E81123"), 1, true));
		
		this.repaint();
	}

	public void setPasswordError(String errorMesseg) {
		passwordError.setText(errorMesseg);
		
		usernameInput.setBorder(
				new LineBorder(Color.decode("#4BBA87"), 1, true));
		
		passwordInput.setText("");
		passwordInput.setBorder(
				new LineBorder(Color.decode("#E81123"), 1, true));
		
		this.repaint();
	}
	
	
	
	
}
