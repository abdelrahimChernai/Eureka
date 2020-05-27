package com.usthb.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import java.io.File;
import java.io.IOException;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.usthb.controler.AppControler;
import com.usthb.dessin.Potence;

 public class EurekaFrame extends JFrame {
	private AppControler manager;
	private PopUp popUp;
	private JPanel baseFrame;
	private JPanel backgound;
	private JPanel homePage;
	private JPanel inscriptionPage;
	private JPanel connectionPage;
	private JPanel themeSelectionPage;
	private JPanel gamePage;
	private Potence hangman;
	public static final int WIDTH = 810;
	public static final int HEIGHT = 620;
	private Font font;
	private Font titleFont;
	
	public EurekaFrame(Potence hangman) {
		this.manager = new AppControler();
		File fontFile = new File("resources\\fonts\\Nunito-Regular.ttf");
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			font = font.deriveFont(14f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		fontFile = new File("resources\\fonts\\youmurdererbb_reg.ttf");
		
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			titleFont = titleFont.deriveFont(63f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		popUp = new PopUp(this, font);
		
		backgound = new JPanel(null, true);
		backgound.setBackground(new Color(0.f, 0.f, 0.f, 0.25f));
		
		homePage = new HomePage(font, titleFont);
		homePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		inscriptionPage = new InscriptionPage(font);
		inscriptionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		connectionPage = new ConnectionPage(font);
		connectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
		
		setupBaseFrame();
		
		this.hangman = hangman;
		this.setTitle("Eureka");
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		this.setContentPane(baseFrame);
		this.setUndecorated(true);
		// mets la par défaut fenêtre au centre de l'ecrant 
		this.setLocationRelativeTo(null);
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
		baseFrame.addMouseListener(manager);
		baseFrame.addMouseMotionListener(manager);
		baseFrame.add(homePage);
	}
	
	public void displayBackground(JPanel panel) {
		backgound.setBounds(0, 1, WIDTH, HEIGHT - 33);
		panel.add(backgound, panel.getComponentCount());
		panel.repaint();
	}
	
	public void removeBackground() {
		JPanel parent = (JPanel) backgound.getParent();
		
		parent.remove(backgound);
		parent.repaint();
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
			, String playerUsername
			, int playerLvl) {

		this.themeSelectionPage = new ThemeSelectionPage(
				themes
				, playerUsername
				, playerLvl
				, font);
		
		this.themeSelectionPage.setBounds(0, 32, WIDTH, HEIGHT - 32);
	}
	
	public GamePage getGamePage() {
		return (GamePage) gamePage;
	}

	public void setGamePage(String username) {
		this.gamePage = new GamePage(username, hangman, font);
		this.gamePage.setBounds(0, 32, WIDTH, HEIGHT - 32);
	}
}
