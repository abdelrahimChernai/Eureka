package com.usthb.vues;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.usthb.controler.AppControler;

public class ConnectionPage extends JPanel {
	private JLabel usernameText;
	private JLabel passwordText;
	JTextField usernameInput;
	JTextField passwordInput;
	JButton confirmButton;
	
	public ConnectionPage() {
		super(null, true);
		
		usernameText = new JLabel("Username");
		usernameText.setBounds(300, 214, 92, 27);
		//	usernameText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameText.setForeground(Color.decode("#FFFFFF"));

		passwordText = new JLabel("Password");
		passwordText.setBounds(300, 303, 80, 27);
		passwordText.setForeground(Color.decode("#FFFFFF"));
		
		usernameInput = new JTextField();
		usernameInput.setBounds(280, 241, 250, 45);
		//	usernameInput.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usernameInput.setBackground(Color.decode("#1A1919"));
		usernameInput.setForeground(Color.decode("#FFFFFF"));
		usernameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		passwordInput = new JTextField();
		passwordInput.setBounds(280, 330, 250, 45);
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
		this.add(passwordText);
		this.add(passwordInput);
		this.add(confirmButton);

	}

	public JTextField getUsernameInput() {
		return usernameInput;
	}

	public JTextField getPasswordInput() {
		return passwordInput;
	}
	
	
}
