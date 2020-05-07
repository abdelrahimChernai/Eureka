package com.usthb.controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.usthb.ErrorCode;
import com.usthb.MainApp;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.ThemeJeu;
import com.usthb.vues.ConnectionPage;
import com.usthb.vues.EurekaFrame;
import com.usthb.vues.GamePage;
import com.usthb.vues.InscriptionPage;

public class AppControler implements ActionListener, MouseListener, KeyListener {
	private static MainApp eurekaRuner;
	private static EurekaFrame gameFrame;
	
	public static void start() {
		eurekaRuner = new  MainApp();
		gameFrame = new EurekaFrame();
		
		eurekaRuner.initialization();
		gameFrame.setVisible(true);
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
	
	public static String getInscriptionFirstname() {
		return gameFrame.getInscriptionPage().getFirsnameInput().getText();
	}
	
	public static String getInscriptionLastname() {
		return gameFrame.getInscriptionPage().getLastnameInput().getText();
	}
	
	public static String getInscriptionBirthDate() {
		return gameFrame.getInscriptionPage().getBirthDateInput().getText();
	}
	
	public static String getInscriptionPassword() {
		InscriptionPage inscriptionPage = gameFrame.getInscriptionPage();
		String password =
				new String(inscriptionPage.getPasswordInput().getPassword());
		return password;
	}
	
	private void startGame(ThemeJeu theme, Joueur player) {
		eurekaRuner.setCurrentGame(new PartieJeu(theme));
		PartieJeu currentGame = eurekaRuner.getCurrentGame();
		GamePage gamePage = gameFrame.getGamePage();
		
		switchPanel(gameFrame.getThemeSelectionPage(), gamePage);
		currentGame.startGame();
		eurekaRuner.getCurrentPlayer().setCurrentLvl();
		gamePage.setQuestion(currentGame.getQuestion().getLable());
		gamePage.setCurrentAnswer(currentGame.getCurrentAnswer());
		gamePage.setLevel(currentGame.getCurrentLevel());
		gamePage.setChansesLeft(currentGame.getAttemptsLeft());
		
		player.addGame(currentGame);
	}

	private void playRound(PartieJeu game) {
		GamePage gamePage = gameFrame.getGamePage();
		
		game.checkChar(gamePage.getPlayerInput().getText().charAt(0));
		
		// On vérifie si le caractère était correcte ou non, si la réponse
		// courante du joueur se trouve inchangé (celle de la partie) donc le
		//caractère est faut
		if (gamePage.getCurrentAnswer().equals(game.getCurrentAnswer())) {
			gamePage.updatePlayerInputState(false);
		} else {
			gamePage.updatePlayerInputState(true);
			gamePage.setCurrentAnswer(game.getCurrentAnswer());
			
			if (eurekaRuner.getCurrentPlayer().getCurrentLvl().getLvlNumber()
				< game.getCurrentLevel()) {
				
				eurekaRuner.getCurrentPlayer().incrementLevel();
				gamePage.setLevel(game.getCurrentLevel());
				gamePage.setQuestion(game.getQuestion().getLable());
			}
		}
		
		gamePage.setChansesLeft(game.getAttemptsLeft());
		gamePage.disableCofirmButton();
	}

	private void switchPanel(JPanel oldPanel, JPanel newPanel) {
		gameFrame.remove(oldPanel);
		gameFrame.add(newPanel);
		gameFrame.repaint();
	}

	public void actionPerformed(ActionEvent e) {
			Component currentPage = ((Component) e.getSource()).getParent();
			String triger = e.getActionCommand(); 
			
			if (triger.contentEquals("")) {
				eurekaRuner.terminate();
				System.exit(0);
			} else if (triger.contentEquals("Continue")) {
				
				if (eurekaRuner.getCurrentPlayer() == null) {
					switchPanel(
							gameFrame.getHomePage()
							, gameFrame.getConnectionPage()
						);
				}
				
			} else if (triger.contentEquals("New Game")) {
				if (eurekaRuner.getCurrentPlayer() != null) {
					LinkedList<String> themes = new LinkedList<String>();
					Iterator<ThemeJeu> it = eurekaRuner.getThemes().iterator();
					
					while (it.hasNext()) {
						themes.add(it.next().getLable());
					}
					
					gameFrame.setThemeSelectionPage(
							themes
							, eurekaRuner.getCurrentPlayer().getUsername()
						);
					
					switchPanel(
							gameFrame.getHomePage()
							, gameFrame.getThemeSelectionPage()
						);
				} else {
					switchPanel(
							gameFrame.getHomePage()
							, gameFrame.getInscriptionPage()
						);
				}
			} else if (triger.contentEquals("Confirm")) {
				if (currentPage.equals(gameFrame.getConnectionPage())) {
					ConnectionPage connectionPage = (ConnectionPage) currentPage;
					ErrorCode error = eurekaRuner.connection();
	
					if (error == ErrorCode.WRONG_USERNAME) {
						connectionPage.setUsernameError(error.getErrorMessage());
					} else if (error == ErrorCode.WRONG_PASSWORD) {
						connectionPage.setPasswordError(error.getErrorMessage());
					} else {
						gameFrame.getHomePage().setUsername(
								eurekaRuner.getCurrentPlayer().getUsername());
	
						switchPanel(connectionPage, gameFrame.getHomePage());
					}
				} else if (currentPage.equals(gameFrame.getInscriptionPage())) {
					InscriptionPage inscriptionPage = (InscriptionPage)currentPage;
					
					eurekaRuner.inscription();
					gameFrame.getHomePage().setUsername(
							eurekaRuner.getCurrentPlayer().getUsername());
	
					switchPanel(inscriptionPage, gameFrame.getHomePage());
				} else if (currentPage.equals(gameFrame.getGamePage())) {
					playRound(eurekaRuner.getCurrentGame());
				}
			} else if (currentPage.equals(gameFrame.getThemeSelectionPage())) {
				Iterator<ThemeJeu> themesIterator =
						eurekaRuner.getThemes().iterator();
				ThemeJeu selectedTheme = null;
				
				while (themesIterator.hasNext() && selectedTheme == null) {
					ThemeJeu theme = themesIterator.next();
					
					if (triger.contentEquals(theme.getLable())) {
						selectedTheme = theme;
					}
				}
				
				if (selectedTheme != null) {
					gameFrame.setGamePage(
							eurekaRuner.getCurrentPlayer().getUsername());
					
					startGame(selectedTheme, eurekaRuner.getCurrentPlayer());
				}
				
			}
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (eurekaRuner.getCurrentPlayer() == null) {
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Component parentPanel = ((Component) e.getSource()).getParent();

		if (parentPanel.equals(gameFrame.getInscriptionPage())) {
			InscriptionPage inscriptionpage = (InscriptionPage) parentPanel;

			String firstName = inscriptionpage.getFirsnameInput().getText();
			String lastName = inscriptionpage.getLastnameInput().getText();
			String username = inscriptionpage.getUsernameInput().getText();
			char[] password = inscriptionpage.getPasswordInput().getPassword();
			char[] passwordConfirmation =
					inscriptionpage.getConfirmPasswordInput().getPassword();
			String dateString = inscriptionpage.getBirthDateInput().getText();
			int day = -1, month = -1, year = -1;
			StringTokenizer birthDateTokenizer =
					new StringTokenizer(dateString);
			try {
				day = Integer.valueOf(birthDateTokenizer.nextToken());
				month = Integer.valueOf(birthDateTokenizer.nextToken()) - 1;
				year = Integer.valueOf(birthDateTokenizer.nextToken()) - 1900;
			} catch (NoSuchElementException e1) {

			}
			Date birthDate = new Date(year, month, day);

			boolean firstNameValid = Joueur.isFirstNameValid(firstName);
			boolean lastNameValid = Joueur.isLastNameValid(lastName);
			boolean dateValid = Joueur.isDateValide(birthDate);
			boolean usernameValid = Joueur.isUsernameValid(username);
			boolean passwordValid = Joueur.isPasswordValid(new String(password));
			boolean confirPasswordValid = true;

			if (passwordConfirmation.length == password.length) {
				for (int i = 0; i < password.length; i++) {

					if (passwordConfirmation[i] != password[i]) {
						confirPasswordValid = false;
					}
				}
			} else {
				confirPasswordValid = false;
			}

			if (e.getSource().equals(inscriptionpage.getFirsnameInput())) {
				firstNameValid = Joueur.isFirstNameValid(firstName);

				inscriptionpage.setFirsnameError("test", firstNameValid);
			} else if (e.getSource().equals(
					inscriptionpage.getLastnameInput())) {

				lastNameValid = Joueur.isLastNameValid(lastName);

				inscriptionpage.setLastnameError("test", lastNameValid);
			} else if (e.getSource().equals(
					inscriptionpage.getUsernameInput())) {

				usernameValid = Joueur.isUsernameValid(username);

				inscriptionpage.setUsernameError("test", usernameValid);
			} else if (e.getSource().equals(
					inscriptionpage.getPasswordInput())) {

				passwordValid = Joueur.isPasswordValid(new String(password));

				inscriptionpage.setPasswordError("test", passwordValid);
			} else if (e.getSource().equals(
					inscriptionpage.getBirthDateInput())) {

				dateValid = Joueur.isDateValide(birthDate);

				inscriptionpage.setBirthDateError("test", dateValid);
			} else if (e.getSource().equals(
					inscriptionpage.getConfirmPasswordInput())) {

				if (passwordConfirmation.length == password.length) {
					for (int i = 0; i < password.length; i++) {

						if (passwordConfirmation[i] != password[i]) {
							confirPasswordValid = false;
						}
					}
				} else {
					confirPasswordValid = false;
				}

				inscriptionpage.setConfirmPasswordError(
						"test"
						, confirPasswordValid
						);

				//Pour des raisons de sécurité on efface les mots de passes
				for (int i = 0; i < password.length; i++) {
					password[i] = 0;
				}

				for (int i = 0; i < passwordConfirmation.length; i++) {
					passwordConfirmation[i] = 0;
				}
			}

			if (firstNameValid
					&& lastNameValid
					&& dateValid
					&& usernameValid
					&& passwordValid
					&& confirPasswordValid) {

				inscriptionpage.enableCofirmButton();
			} else {
				inscriptionpage.disableCofirmButton();
			}
		} else if (parentPanel.equals(gameFrame.getConnectionPage())) {
			ConnectionPage connectionPage = (ConnectionPage) parentPanel;
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				if (e.getSource().equals(connectionPage.getUsernameInput())) {
					if(! connectionPage.getPasswordInput().getText()
							.isBlank()) {

						connectionPage.getConfirmButton().doClick();
					}
				} else if (e.getSource().equals(
						connectionPage.getPasswordInput())) {

					if (!connectionPage.getUsernameInput().getText()
							.isBlank()) {

						connectionPage.getConfirmButton().doClick();
					}
				}
			}
		} else if (parentPanel.equals(gameFrame.getGamePage())) {
			GamePage gamePage = (GamePage) parentPanel;

			if (e.getSource().equals(gamePage.getPlayerInput())) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (gamePage.getConfirmButton().isEnabled()) {
						gamePage.getConfirmButton().doClick();
					}
				} else if (gamePage.getPlayerInput().getText().length() == 1) {
					gamePage.enableCofirmButton();
				} else {
					gamePage.disableCofirmButton();
				}
			}
		}
	}	
}
