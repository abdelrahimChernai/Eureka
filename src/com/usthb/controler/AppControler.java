package com.usthb.controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.usthb.ErrorCode;
import com.usthb.MainApp;
import com.usthb.modeles.Levels;
import com.usthb.modeles.ThemeJeu;
import com.usthb.vues.EurekaFrame;
import com.usthb.vues.InscriptionPage;

public class AppControler implements ActionListener, MouseListener, KeyListener{
	private static MainApp eurekaRuner;
	private static EurekaFrame gameFrame;
	
	public static void start() {
		eurekaRuner = new  MainApp();
		eurekaRuner.initialization();
		
		gameFrame = new EurekaFrame();
		gameFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String triger = e.getActionCommand(); 
		
		if (triger.contentEquals("")) {
			System.exit(0);
		} else if (triger.contentEquals("Continue")) {
			
			if (eurekaRuner.getCurrnetPlayer() == null) {
				switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getConnectionPage()
					);
			}
			
		} else if (triger.contentEquals("New Game")) {
			if (eurekaRuner.getCurrnetPlayer() != null) {
				LinkedList<String> themes = new LinkedList<String>();
				Iterator<ThemeJeu> it = eurekaRuner.getThemes().iterator();
				
				while (it.hasNext()) {
					themes.add(it.next().getLable());
				}
				
				gameFrame.setThemeSelectionPage(
						themes
						, eurekaRuner.getCurrnetPlayer().getUsername()
					);
				
				switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getThemeSelectionPage()
					);
			}
		} else if (triger.contentEquals("Confirm")) {
			if (((
					Component) e.getSource()
				).getParent().equals(gameFrame.getConnectionPage())) {
				
				ErrorCode error = eurekaRuner.connection();

				if (error == ErrorCode.WRONG_USERNAME) {
					gameFrame.getConnectionPage().setUsernameError(
							error.getErrorMessage());
				} else if (error == ErrorCode.WRONG_PASSWORD) {
					gameFrame.getConnectionPage().setPasswordError(
							error.getErrorMessage());
				} else {
					gameFrame.getHomePage().setUsername(
							eurekaRuner.getCurrnetPlayer().getUsername());

					switchPanel(
							gameFrame.getConnectionPage()
							, gameFrame.getHomePage()
							);
					eurekaRuner.getCurrnetPlayer().setCurrentLvl(Levels.LEVEL_3);
					System.out.println(eurekaRuner.getCurrnetPlayer());
				}
			} else {
				
			}
		}
	}
	
	private void switchPanel(JPanel oldPanel, JPanel newPanel) {
		gameFrame.remove(oldPanel);
		gameFrame.add(newPanel);
		gameFrame.repaint();
	}
	
	public static String getConnectionUsername() {
		return gameFrame.getConnectionPage().getUsernameInput().getText();
	}
	
	public static String getConnectionPassword() {
		return gameFrame.getConnectionPage().getPasswordInput().getText();
	}
	
	public static String getInscriptionUsername() {
		return gameFrame.getInscriptionPage().getUsernameInput().getText();
	}
	
	public static String getInscriptionPassword() {
		InscriptionPage inscriptionPage = gameFrame.getInscriptionPage();
		return inscriptionPage.getPasswordInput().getPassword().toString();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (eurekaRuner.getCurrnetPlayer() == null) {
			int triger = e.getButton();
		
			if (triger == MouseEvent.BUTTON1) {
				switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getConnectionPage()
						);
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Component parentPanel = ((Component) e.getSource()).getParent();
		
		if (parentPanel.equals(gameFrame.getInscriptionPage())) {
			InscriptionPage inscriptionpage = (InscriptionPage) parentPanel;
			
			if (inscriptionpage.getFirsnameInput().getText().equals("")
				|| inscriptionpage.getLastnameInput().getText().equals("")
				|| inscriptionpage.getBirthDateInput().getText().equals("")
				|| inscriptionpage.getUsernameInput().getText().equals("")) {
				
				System.out.println(inscriptionpage.getUsernameInput().getText());
				
				inscriptionpage.disableCofirmButton();
			} else {
				inscriptionpage.enableCofirmButton();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	

}
