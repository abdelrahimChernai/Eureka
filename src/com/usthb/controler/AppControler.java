package com.usthb.controler;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.usthb.ErrorCode;
import com.usthb.MainApp;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.ThemeJeu;
import com.usthb.modeles.ThemeType;
import com.usthb.vues.ConnectionPage;
import com.usthb.vues.EurekaFrame;
import com.usthb.vues.GamePage;
import com.usthb.vues.InscriptionPage;
import com.usthb.vues.Leaderboard;
import com.usthb.vues.PopUp;


public class AppControler implements
	ActionListener
	, MouseListener
	, MouseMotionListener
	, KeyListener {
	
	private static MainApp eurekaRunner;
	private static EurekaFrame gameFrame;
	private static Stack<JPanel> backStack;
	
	//La position d'un clique, utilisé pour pouvoir bouger la fenêtre
	private int x, y;
	
	public static void start() {
		eurekaRunner = new  MainApp();
		gameFrame = new EurekaFrame(PartieJeu.getHangman());
		backStack = new Stack<JPanel>();

		eurekaRunner.initialization();
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
		gameFrame.getGamePage().getPlayerInput().setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		eurekaRunner.setCurrentGame(new PartieJeu(
				theme
				, eurekaRunner.getCurrentPlayer().getQuestions(theme)));
		PartieJeu currentGame = eurekaRunner.getCurrentGame();
		GamePage gamePage = gameFrame.getGamePage();
		
		currentGame.startGame();
		eurekaRunner.getCurrentPlayer().setCurrentLvl();
		gamePage.setQuestion(currentGame.getQuestion().getLable());
		gamePage.setCurrentAnswer(currentGame.getCurrentAnswer());
		gamePage.setLevel(currentGame.getCurrentLevel());
		gamePage.setChansesLeft(currentGame.getAttemptsLeft());
		gamePage.setScore(currentGame.getScore());
		switchPanel(gameFrame.getThemeSelectionPage(), gamePage);
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
			
			if (eurekaRunner.getCurrentPlayer().getCurrentLvl().getLvlNumber()
				< game.getCurrentLevel()) {
				
				eurekaRunner.getCurrentPlayer().incrementLevel();
				gamePage.setLevel(game.getCurrentLevel());
				gamePage.setQuestion(game.getQuestion().getLable());
			}
		}
		
		gamePage.setChansesLeft(game.getAttemptsLeft());
		gamePage.setScore(game.getScore());
		gamePage.disableCofirmButton();
		
		if (game.isWin()) {
			gameFrame.displayBackground(gameFrame.getGamePage());
			gameFrame.getPopUp().displayGameFinished(
					gameFrame.getLocation()
					, true
					, game.getScore());
			
			eurekaRunner.getCurrentPlayer().addGame(
					eurekaRunner.getCurrentGame());
		} else if (game.getAttemptsLeft() == 0) {
			gameFrame.displayBackground(gameFrame.getGamePage());
			gameFrame.getPopUp().displayGameFinished(
					gameFrame.getLocation()
					, false
					, game.getScore());
			eurekaRunner.getCurrentPlayer().addGame(
					eurekaRunner.getCurrentGame());
		}
	}
	
	private void loadGame(PartieJeu game) {
		gameFrame.setGamePage(eurekaRunner.getCurrentPlayer().getUsername());
		gameFrame.getGamePage().getPlayerInput().setBorder(
				new LineBorder(Color.decode("#FFFFFF"), 1, true));
		eurekaRunner.setCurrentGame(game);
		
		GamePage gamePage = gameFrame.getGamePage();
		
		switchPanel(gameFrame.getHomePage(), gamePage);
		
		gamePage.setQuestion(game.getQuestion().getLable());
		gamePage.setCurrentAnswer(game.getCurrentAnswer());
		gamePage.setLevel(game.getCurrentLevel());
		gamePage.setChansesLeft(game.getAttemptsLeft());
		gamePage.setScore(game.getScore());
	}

	private void switchPanel(JPanel oldPanel, JPanel newPanel) {
		gameFrame.remove(oldPanel);
		gameFrame.add(newPanel);
		gameFrame.repaint();
		
		if (backStack.contains(newPanel)) {
			while(!backStack.empty() && backStack.pop().equals(newPanel));
		} else {
			backStack.push(oldPanel);
		}
	}
	
	private void goBack(JPanel currnetPanel) {
		JPanel newPanel = backStack.pop();
		
		gameFrame.remove(currnetPanel);
		gameFrame.add(newPanel);
		gameFrame.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
			Component currentPage = ((Component) e.getSource()).getParent();
			String triger = e.getActionCommand(); 
			
			if (triger.contentEquals("")) {
				if (currentPage.equals(gameFrame.getPopUp().getBaseFrame())) {
					gameFrame.getPopUp().removePopUp();
					gameFrame.removeBackground();
				} else {
					JPanel parent = (JPanel) ((Component) e.getSource())
							.getParent();
					
					for (Component component : parent.getComponents()) {
						if (component.equals(gameFrame.getGamePage())) {
							eurekaRunner.getCurrentPlayer().addGame(
									eurekaRunner.getCurrentGame());
						}
					}
					
					eurekaRunner.terminate();
					System.exit(0);
				}
				
			} else if (triger.contentEquals("Leaderboard")) {
				gameFrame.setLeaderboard();
				ArrayList<String> players = eurekaRunner.getPlayers();
				
				switchPanel(gameFrame.getHomePage(), gameFrame.getLeaderboard());
				
				for (String player : players) {
					gameFrame.addPlayerToLeaderboard(player);
				}
				
			} else if (triger.contentEquals("Continue")) {
				
				if (eurekaRunner.getCurrentPlayer() != null) {
					if (eurekaRunner.getCurrentPlayer().hasCurrentGmae()) {

						loadGame(eurekaRunner.getCurrentPlayer()
								.getLastGame());
						
						eurekaRunner.getCurrentPlayer().removeLastGame();
					} else {
						gameFrame.displayBackground(gameFrame.getHomePage());
						gameFrame.getPopUp().displayNoCurrentGame(
								gameFrame.getLocation());
					}
				} else {
					gameFrame.displayBackground(gameFrame.getHomePage());
					gameFrame.getPopUp().displayNotConnected(
							gameFrame.getLocation());
				}
				
			} else if (triger.contentEquals("New Game")) {
				if (eurekaRunner.getCurrentPlayer() != null) {
					LinkedList<String> themes = new LinkedList<String>();
					Iterator<ThemeJeu> it = eurekaRunner.getThemes().iterator();
					
					while (it.hasNext()) {
						themes.add(it.next().getLable());
					}
					
					gameFrame.setThemeSelectionPage(
							themes
							, eurekaRunner.getCurrentPlayer().getUsername()
							, eurekaRunner.getCurrentPlayer().getCurrentLvl()
								.getLvlNumber()
						);
					
					if (((JButton) e.getSource()).getParent().
							equals(gameFrame.getHomePage())) {
						
						Joueur currentPlayer = eurekaRunner.getCurrentPlayer();
						
						if (!currentPlayer.hasCurrentGmae()) {
							
							switchPanel(
									gameFrame.getHomePage()
									, gameFrame.getThemeSelectionPage()
								);
						} else {
							gameFrame.displayBackground(gameFrame.getHomePage());
							gameFrame.getPopUp().displayLoseProgress(
									gameFrame.getLocation());
						}
					} else if (((JButton) e.getSource()).getParent()
							.equals(gameFrame.getPopUp().getGameFinished())) {

						gameFrame.getPopUp().removePopUp();
						gameFrame.removeBackground();
						switchPanel(
								gameFrame.getGamePage()
								, gameFrame.getThemeSelectionPage()
							);
					} else {
						eurekaRunner.getCurrentPlayer().removeLastGame();
						gameFrame.getPopUp().removePopUp();
						gameFrame.removeBackground();
						switchPanel(
								gameFrame.getHomePage()
								, gameFrame.getThemeSelectionPage()
							);
					}
				} else {
					gameFrame.displayBackground(gameFrame.getHomePage());
					gameFrame.getPopUp().displayNotConnected(
							gameFrame.getLocation());
				}
			} else if (triger.contentEquals("Confirm")) {
				if (currentPage.equals(gameFrame.getConnectionPage())) {
					ConnectionPage connectionPage = (ConnectionPage) currentPage;
					ErrorCode error = eurekaRunner.connection();
	
					if (error.equals(ErrorCode.WRONG_USERNAME)) {
						connectionPage.setUsernameError(error.getErrorMessage());
					} else if (error.equals(ErrorCode.WRONG_PASSWORD)) {
						connectionPage.setPasswordError(error.getErrorMessage());
					} else if (error.equals(ErrorCode.NO_ERROR)){
						gameFrame.getHomePage().setPlayerText(
							eurekaRunner.getCurrentPlayer().getUsername()
							, eurekaRunner.getCurrentPlayer().getCurrentLvl().
								getLvlNumber());
						
						switchPanel(connectionPage, gameFrame.getHomePage());
					}
				} else if (currentPage.equals(gameFrame.getInscriptionPage())) {
					InscriptionPage inscriptionPage = (InscriptionPage)currentPage;
					ErrorCode error = eurekaRunner.inscription();
					
					if (error.equals(ErrorCode.UNAVALABLE_USERNAME)) {
						inscriptionPage.setUsernameError(
								error.getErrorMessage()
								, false);
						inscriptionPage.getPasswordInput().setText("");
						inscriptionPage.getConfirmPasswordInput().setText("");
						
					} else if (error.equals(ErrorCode.UNVALID_DATE_FORMAT)) {
						inscriptionPage.setBirthDateError(
								error.getErrorMessage()
								, false);
						
					} else if (error.equals(ErrorCode.NO_ERROR)) {
						int lvl = 0;
						
						if (eurekaRunner.getCurrentPlayer().getCurrentLvl()
								!= null) {
							lvl = eurekaRunner.getCurrentPlayer()
									.getCurrentLvl().getLvlNumber();
						}
						gameFrame.getHomePage().setPlayerText(
							eurekaRunner.getCurrentPlayer().getUsername()
							, lvl);
						gameFrame.getHomePage().hideAccountCreation();
						switchPanel(inscriptionPage, gameFrame.getHomePage());
					}
					
				} else if (currentPage.equals(gameFrame.getGamePage())) {
					playRound(eurekaRunner.getCurrentGame());
				}
			} else if (currentPage.equals(gameFrame.getThemeSelectionPage())) {
				
				Iterator<ThemeJeu> themesIterator =
						eurekaRunner.getThemes().iterator();
				ThemeJeu selectedTheme = null;
				
				while (themesIterator.hasNext() && selectedTheme == null) {
					ThemeJeu theme = themesIterator.next();
					
					if (triger.contentEquals(theme.getLable())) {
						selectedTheme = theme;
					}
				}
				
				if (selectedTheme != null) {
					gameFrame.setGamePage(
							eurekaRunner.getCurrentPlayer().getUsername());
					
					startGame(selectedTheme, eurekaRunner.getCurrentPlayer());
				}
				
			} else if (triger.contentEquals("Home Page")) {
				gameFrame.getPopUp().removePopUp();
				gameFrame.removeBackground();
				switchPanel(
						gameFrame.getGamePage()
						, gameFrame.getHomePage()
					);
			} else if (triger.contentEquals("Replay")) {
				gameFrame.getPopUp().removePopUp();
				gameFrame.removeBackground();
				startGame(eurekaRunner.getCurrentGame().getTheme()
						, eurekaRunner.getCurrentPlayer());
			} else if (triger.contentEquals("Log In")) {
				gameFrame.getPopUp().removePopUp();
				gameFrame.removeBackground();
				switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getConnectionPage()
					);
			} else if (triger.contentEquals("Create Account")) {
				gameFrame.getPopUp().removePopUp();
				gameFrame.removeBackground();
				switchPanel(
						gameFrame.getHomePage()
						, gameFrame.getInscriptionPage()
					);
			} else if (triger.contentEquals("Cancel")
					|| triger.contentEquals("Okay")) {
				
				gameFrame.getPopUp().removePopUp();
				gameFrame.removeBackground();
			}
		}

	@Override
	public void mouseClicked(MouseEvent e) {		
		if (e.getSource().getClass().equals(JLabel.class)) {
			JLabel label = (JLabel) e.getSource();
			int triger = e.getButton();
			boolean noPlayer = eurekaRunner.getCurrentPlayer() == null;
			
			if (triger == MouseEvent.BUTTON1) {

				if (label.getText().equals("Back")) {
					
					if(label.getParent().equals(gameFrame.getGamePage())) {
						eurekaRunner.getCurrentPlayer()
							.addGame(eurekaRunner.getCurrentGame());
					}
					
					goBack((JPanel) label.getParent());
					
				} else if (label.getText().equals("Log In") && noPlayer) {

					switchPanel(
							gameFrame.getHomePage()
							, gameFrame.getConnectionPage()
							);
				} else if (label.getText().equals("Creat one now!")) {

					switchPanel(
							gameFrame.getHomePage()
							, gameFrame.getInscriptionPage()
							);
				} else if (label.getText().equals("About")) {
					gameFrame.displayBackground(gameFrame.getHomePage());
					gameFrame.getPopUp().displayAbout(gameFrame.getLocation());
				} else if (label.getText().equals("Help")
						|| label.getText().equals("?")) {
					
					gameFrame.displayBackground(gameFrame.getHomePage());
					gameFrame.getPopUp().displayHelp(gameFrame.getLocation());
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getY() < 32) { 
			this.x = e.getX();
			this.y = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getY() < 32) { 
			gameFrame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
			int day, month, year;
			StringTokenizer birthDateTokenizer =
					new StringTokenizer(dateString);
			Calendar birthDate;
			try {
				day = Integer.valueOf(birthDateTokenizer.nextToken());
				month = Integer.valueOf(birthDateTokenizer.nextToken()) - 1;
				year = Integer.valueOf(birthDateTokenizer.nextToken());
			} catch (NoSuchElementException e1) {
				day = -1;
				month = -1;
				year = -1;
			}
			
			birthDate = Joueur.checkDate(year, month, day);
			
			boolean firstNameValid = Joueur.isFirstNameValid(firstName);
			boolean lastNameValid = Joueur.isLastNameValid(lastName);
			boolean dateValid = birthDate != null;
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
			
			//Pour des raisons de sécurité on efface les mots de passes
			for (int i = 0; i < password.length; i++) {
				password[i] = 0;
			}

			for (int i = 0; i < passwordConfirmation.length; i++) {
				passwordConfirmation[i] = 0;
			}

			if (e.getSource().equals(inscriptionpage.getFirsnameInput())) {
				inscriptionpage.setFirsnameError(
						ErrorCode.UNVALID_NAME.getErrorMessage()
						, firstNameValid);
				
			} else if (e.getSource().equals(
					inscriptionpage.getLastnameInput())) {

				inscriptionpage.setLastnameError(
						ErrorCode.UNVALID_NAME.getErrorMessage()
						, lastNameValid);
				
			} else if (e.getSource().equals(
					inscriptionpage.getBirthDateInput())) {
				
				inscriptionpage.setBirthDateError(
						ErrorCode.UNVALID_DATE_FORMAT.getErrorMessage()
						, dateValid);
				
			} else if (e.getSource().equals(
					inscriptionpage.getUsernameInput())) {

				inscriptionpage.setUsernameError(
						ErrorCode.UNVALID_USERNAME.getErrorMessage()
						, usernameValid);
				
			} else if (e.getSource().equals(
					inscriptionpage.getPasswordInput())) {

				inscriptionpage.setPasswordError(
						ErrorCode.UNVALID_PASSWORD.getErrorMessage()
						, passwordValid);
				
			} else if (e.getSource().equals(
					inscriptionpage.getConfirmPasswordInput())) {

				inscriptionpage.setConfirmPasswordError(
						ErrorCode.WRONG_CONFIRM_PASSWORD.getErrorMessage()
						, confirPasswordValid);
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
