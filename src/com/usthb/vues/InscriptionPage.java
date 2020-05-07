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

public class InscriptionPage extends JPanel {
	private AppControler manager = new AppControler();
	
	private JLabel firsnameText;
	private JLabel lastnameText;
	private JLabel birthDateText;
	private JLabel usernameText;
	private JLabel passwordText;
	private JLabel confirmPasswordText;
	
	private JLabel firsnameError;
	private JLabel lastnameError;
	private JLabel birthDateError;
	private JLabel usernameError;
	private JLabel passwordError;
	private JLabel confirmPasswordError;
	
	private JTextField firsnameInput;
	private JTextField lastnameInput;
	private JTextField usernameInput;
	private JTextField birthDateInput;
	private JPasswordField passwordInput;
	private JPasswordField confirmPasswordInput;
	private JButton confirmButton;
	
	public InscriptionPage() {
		super(null, true);
		
		firsnameText = new JLabel("Firsname");
		firsnameText.setBounds(154, 127, 82, 27);
		firsnameText.setForeground(Color.decode("#FFFFFF"));
		
		lastnameText = new JLabel("Lastname");
		lastnameText.setBounds(154, 232, 88, 27);
		lastnameText.setForeground(Color.decode("#FFFFFF"));
		
		birthDateText = new JLabel("Date of Birth");
		birthDateText.setBounds(154, 337, 115, 27);
		birthDateText.setForeground(Color.decode("#FFFFFF"));
		
		usernameText = new JLabel("Username");
		usernameText.setBounds(447, 127, 92, 27);
		usernameText.setForeground(Color.decode("#FFFFFF"));
		
		passwordText = new JLabel("Password");
		passwordText.setBounds(447, 232, 80, 27);
		passwordText.setForeground(Color.decode("#FFFFFF"));
		
		confirmPasswordText = new JLabel("Confirm password");
		confirmPasswordText.setBounds(447, 337, 164, 27);
		confirmPasswordText.setForeground(Color.decode("#FFFFFF"));
		
		
		firsnameError = new JLabel();
		firsnameError.setBounds(134, 202, 111, 20);
		firsnameError.setForeground(Color.decode("#E81123"));
		
		lastnameError = new JLabel();
		lastnameError.setBounds(134, 307, 111, 20);
		lastnameError.setForeground(Color.decode("#E81123"));
		
		birthDateError = new JLabel();
		birthDateError.setBounds(134, 412, 111, 20);
		birthDateError.setForeground(Color.decode("#E81123"));
		
		usernameError = new JLabel();
		usernameError.setBounds(427, 202, 111, 20);
		usernameError.setForeground(Color.decode("#E81123"));
		
		passwordError = new JLabel();
		passwordError.setBounds(427, 307, 111, 20);
		passwordError.setForeground(Color.decode("#E81123"));
		
		confirmPasswordError = new JLabel();
		confirmPasswordError.setBounds(427, 412, 111, 20);
		confirmPasswordError.setForeground(Color.decode("#E81123"));
		
		
		firsnameInput = new JTextField();
		firsnameInput.setBounds(134, 154, 250, 45);
		firsnameInput.setHorizontalAlignment(SwingConstants.CENTER);
		firsnameInput.setBackground(Color.decode("#1A1919"));	
		firsnameInput.setForeground(Color.decode("#FFFFFF"));
		firsnameInput.addKeyListener(manager);
		firsnameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		lastnameInput = new JTextField();
		lastnameInput.setBounds(134, 259, 250, 45);
		lastnameInput.setHorizontalAlignment(SwingConstants.CENTER);
		lastnameInput.setBackground(Color.decode("#1A1919"));	
		lastnameInput.setForeground(Color.decode("#FFFFFF"));
		lastnameInput.addKeyListener(manager);
		lastnameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		birthDateInput = new JTextField();
		birthDateInput.setBounds(134, 364, 250, 45);
		birthDateInput.setHorizontalAlignment(SwingConstants.CENTER);
		birthDateInput.setBackground(Color.decode("#1A1919"));	
		birthDateInput.setForeground(Color.decode("#FFFFFF"));
		birthDateInput.addKeyListener(manager);
		birthDateInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		usernameInput = new JTextField();
		usernameInput.setBounds(427, 154, 250, 45);
		usernameInput.setHorizontalAlignment(SwingConstants.CENTER);
		usernameInput.setBackground(Color.decode("#1A1919"));	
		usernameInput.setForeground(Color.decode("#FFFFFF"));
		usernameInput.addKeyListener(manager);
		usernameInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(427, 259, 250, 45);
		passwordInput.setHorizontalAlignment(SwingConstants.CENTER);
		passwordInput.setBackground(Color.decode("#1A1919"));	
		passwordInput.setForeground(Color.decode("#FFFFFF"));
		passwordInput.addKeyListener(manager);
		passwordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		confirmPasswordInput = new JPasswordField();
		confirmPasswordInput.setBounds(427, 364, 250, 45);
		confirmPasswordInput.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPasswordInput.setBackground(Color.decode("#1A1919"));	
		confirmPasswordInput.setForeground(Color.decode("#FFFFFF"));
		confirmPasswordInput.addKeyListener(manager);
		confirmPasswordInput.setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBorderPainted(false);
		confirmButton.setFocusPainted(false);
		confirmButton.setBounds(280, 489, 250, 45);
		confirmButton.setBackground(Color.decode("#326C52"));
		confirmButton.setForeground(Color.decode("#FFFFFF"));
		confirmButton.addActionListener(manager);
		confirmButton.setEnabled(false);
		
		
		this.setBackground(Color.decode("#1A1919"));
		
		this.add(firsnameText);
		this.add(firsnameInput);
		this.add(firsnameError);
		
		this.add(lastnameText);
		this.add(lastnameInput);
		this.add(lastnameError);
		
		this.add(birthDateText);
		this.add(birthDateInput);
		this.add(birthDateError);
		
		this.add(usernameText);
		this.add(usernameInput);
		this.add(usernameError);
		
		this.add(passwordText);
		this.add(passwordInput);
		this.add(passwordError);
		
		this.add(confirmPasswordText);
		this.add(confirmPasswordInput);
		this.add(confirmPasswordError);
		
		this.add(confirmButton);
	}
	

	public void setFirsnameError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = firsnameInput.getBounds().x
					+ (firsnameInput.getBounds().width / 2);

			firsnameError.setBounds(centerOnX - (width / 2), 202, width, 20);
			firsnameError.setText(errorMesseg);
			firsnameError.setHorizontalAlignment(SwingConstants.CENTER);

			firsnameInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			firsnameError.setText("");
			
			firsnameInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}

	public void setLastnameError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = lastnameInput.getBounds().x
					+ (lastnameInput.getBounds().width / 2);

			lastnameError.setBounds(centerOnX - (width / 2), 307, width, 20);
			lastnameError.setText(errorMesseg);
			lastnameError.setHorizontalAlignment(SwingConstants.CENTER);

			lastnameInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			lastnameError.setText("");
			
			lastnameInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}

	public void setBirthDateError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = birthDateInput.getBounds().x
					+ (birthDateInput.getBounds().width / 2);

			birthDateError.setBounds(centerOnX - (width / 2), 412, width, 20);
			birthDateError.setText(errorMesseg);
			birthDateError.setHorizontalAlignment(SwingConstants.CENTER);

			birthDateInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			birthDateError.setText("");
			
			birthDateInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}

	public void setUsernameError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = usernameInput.getBounds().x
					+ (usernameInput.getBounds().width / 2);

			usernameError.setBounds(centerOnX - (width / 2), 202, width, 20);
			usernameError.setText(errorMesseg);
			usernameError.setHorizontalAlignment(SwingConstants.CENTER);
			
			usernameInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			usernameError.setText("");
			
			usernameInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}


	public void setPasswordError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = passwordInput.getBounds().x
					+ (passwordInput.getBounds().width / 2);

			passwordError.setBounds(centerOnX - (width / 2), 307, width, 20);
			passwordError.setText(errorMesseg);
			passwordError.setHorizontalAlignment(SwingConstants.CENTER);

			passwordInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			passwordError.setText("");
			
			passwordInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}

	public void setConfirmPasswordError(String errorMesseg, boolean valid) {
		if (!valid) {
			int width =  errorMesseg.length() * 7;
			int centerOnX = confirmPasswordInput.getBounds().x
					+ (confirmPasswordInput.getBounds().width / 2);

			confirmPasswordError.setBounds(centerOnX - (width / 2), 412, width, 20);
			confirmPasswordError.setText(errorMesseg);
			confirmPasswordError.setHorizontalAlignment(SwingConstants.CENTER);

			confirmPasswordInput.setBorder(
					new LineBorder(Color.decode("#E81123"), 1, true));
		} else {
			confirmPasswordError.setText("");
			
			confirmPasswordInput.setBorder(
					new LineBorder(Color.decode("#FFFFFF"), 1, true));
		}
		
		this.repaint();
	}

	public JTextField getFirsnameInput() {
		return firsnameInput;
	}

	public JTextField getLastnameInput() {
		return lastnameInput;
	}

	public JTextField getUsernameInput() {
		return usernameInput;
	}

	public JTextField getBirthDateInput() {
		return birthDateInput;
	}

	public JPasswordField getPasswordInput() {
		return passwordInput;
	}

	public JPasswordField getConfirmPasswordInput() {
		return confirmPasswordInput;
	}
	
	public void enableCofirmButton() {
		confirmButton.setBackground(Color.decode("#4BBA87"));
		confirmButton.setEnabled(true);
	}
	
	public void disableCofirmButton() {
		confirmButton.setBackground(Color.decode("#326C52"));
		confirmButton.setEnabled(false);
	}
}
