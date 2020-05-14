package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.PopupMenu;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;

import com.usthb.controler.AppControler;

 public class EurekaFrame extends JFrame {
	private PopUp popUp;
	private JPanel baseFrame;
	private JPanel homePage;
	private JPanel inscriptionPage;
	private JPanel connectionPage;
	private JPanel themeSelectionPage;
	private JPanel gamePage;
	public static final int WIDTH = 810;
	public static final int HEIGHT = 620;
	public Font font;
	
	public EurekaFrame() {
		File fontFile = new File("resources\\fonts\\Nunito-Regular.ttf");
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			font = font.deriveFont(14f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		popUp = new PopUp(this);
		
		homePage = new HomePage(font);
		homePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		inscriptionPage = new InscriptionPage(font);
		inscriptionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		connectionPage = new ConnectionPage(font);
		connectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		setupBaseFrame();
		
		this.setTitle("Eureka");
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		this.setContentPane(baseFrame);
		this.setUndecorated(true);
	}
	
	private void setupBaseFrame() {
		JButton closeButton = new JButton("");
		
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setBounds(WIDTH - 46, 1, 45, 28);
		closeButton.setBackground(Color.decode("#E81123"));
		closeButton.addActionListener(new AppControler());
		
		
		
	
		baseFrame = new JPanel(null, true);
		baseFrame.setBackground(Color.decode("#000000"));
		baseFrame.setBounds(0, 0, WIDTH, HEIGHT);
		baseFrame.add(closeButton);
		baseFrame.add(homePage);
	}
	
	public PopUp getPopUp() {
		return popUp;
	}

	public JPanel getBaseFrame() {
		return baseFrame;
	}

	public HomePage getHomePage() {
		return (HomePage) homePage;
	}
	
	public InscriptionPage getInscriptionPage() {
		return (InscriptionPage) inscriptionPage;
	}

	public ConnectionPage getConnectionPage() {
		return (ConnectionPage) connectionPage;
	}

	public JPanel getThemeSelectionPage() {
		return themeSelectionPage;
	}
	
	public void setThemeSelectionPage(
			LinkedList<String> themes
			, String username) {

		this.themeSelectionPage = new ThemeSelectionPage(
				themes
				, username
				, font);
		
		this.themeSelectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
	}
	
	public GamePage getGamePage() {
		return (GamePage) gamePage;
	}

	public void setGamePage(String username) {

		this.gamePage = new GamePage(username, font);
		this.gamePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
	}
}
