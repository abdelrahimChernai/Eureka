package com.usthb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import com.usthb.controler.AppControler;
import com.usthb.modeles.Adulte;
import com.usthb.modeles.Enfant;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.ThemeJeu;

/**
 * <b>
 *  MainApp est la classe contenant le point d'entr�e du programme donc elle
 *  repr�sente l'application
 * </b>
 * <p>
 *	Repr�sente les composantes "logique" du programme et c'est a travers une
 *	instance de cette classe que les traitement se font dans le contr�leur 
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.1
 */
public class MainApp {
	
	
	/**
	 * utilis� pour la lecture des questions
	 */
	public static Scanner console = new Scanner(System.in);
	
	
	/**
	 * Repr�sente le joueur connect�
	 */
	private Joueur currnetPlayer;
	
	
	/**
	 * Repr�sente la partie en cours
	 */
	private PartieJeu currentGame;
	
	/**
	 * <p>
	 * 	Contient tous les joueurs inscrits auparavant, sera initialis� � partir
	 *  d'un ficher contenant ces derniers. Voir la documentation de 
	 *  l'initialisation pour plus de d�tails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see MainApp#initialization()
	 */
	private HashMap<Integer, Joueur> players;
	
	/**
	 * <p>
	 * 	Contient tous les th�mes disponibles, sera initialis� � partir de deux
	 * 	fichiers diff�rents : un contenant les th�mes, l'autre les questions.
	 * 	Voir la m�thode initialisation pour plus de d�tails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.ThemeJeu
	 * @see com.usthb.modeles.Question
	 */
	private HashSet<ThemeJeu> themes;
	
	
	/**
	 * Initialisation des valeur n�cessaire 
	 */
	public MainApp() {
		this.players = new HashMap<Integer, Joueur>();
		this.themes  = new HashSet<ThemeJeu>();
		this.currnetPlayer = null;
	}


	/**
	 * <p>
	 * 	Se lance d�s le lancement du jeu pour pr�parer les �l�ments et donn�es
	 * 	n�cessaires en R�cup�rant la liste des joueurs et la list des th�mes
	 * 	depuis un fichier.
	 * </p>
	 *
	 * @see MainApp#themes
	 * @see MainApp#players
	 */
	public void initialization() {
		File playerFile = new File("resources\\save\\player.sve");
		File themeFile = new File("resources\\save\\themes.sve");
		
		if (playerFile.exists()) {
			try {
				ObjectInputStream playerFileIn =
						new ObjectInputStream(new FileInputStream(playerFile));
				
				players = (HashMap<Integer, Joueur>) playerFileIn.readObject();
				
			
				try {
					playerFileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				playerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (themeFile.exists()) {
			try {
				ObjectInputStream themeFileIn =
						new ObjectInputStream(new FileInputStream(themeFile));
			
				themes = (HashSet<ThemeJeu>) themeFileIn.readObject();
				try {
					themeFileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				themeFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * <p>
	 * 	v�rifie si l'id g�n�r� par le nom d'utilisateur entr� existe sinon
	 * 	Retourne un code d'erreur, si le non d'utilisateur est valide v�rifie
	 * 	si le mot de passe est correspondant au profile repr�sent� par le nom
	 * 	d'utilisateur, sinon retourne une erreur, si le bon mot de passe est
	 * 	ins�r�, retourne un code NO_ERROR qui permet de continuer vers la home
	 * 	page
	 * </p>
	 * @return Un code d'erreur correspondent a l'erreur rencontr�
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see com.usthb.modeles.Joueur#hashCode()
	 * @see com.usthb.modeles.Joueur#id
	 * @see com.usthb.modeles.Joueur#setId()
	 * 
	 * @see com.usthb.ErrorCode
	 * 
	 * @see com.usthb.controler.AppControler
	 * 
	 * @since 1.2
	 */
	public ErrorCode connection() {
		String username;
		String password;
		
		username = AppControler.getConnectionUsername();

		if (! players.containsKey(Joueur.hashCode(username))) {
			return ErrorCode.WRONG_USERNAME;
		}

		password = AppControler.getConnectionPassword();

		if (!players.get(
				Joueur.hashCode(username)).getPassword().equals(password)) {
			
			return ErrorCode.WRONG_PASSWORD;
		}
			
		currnetPlayer =  players.get(Joueur.hashCode(username));
		
		return ErrorCode.NO_ERROR;
	}
	
	/**
	 * <p>
	 *	R�cup�re le Nom, Pr�nom, date de naissance et nom d'utilisateur puis
	 *	cr�e un id et v�rifie qu'il n'existe pas dans la liste des joueurs et
	 *	que les formats son valide sinon existe retourne une erreur, insert le
	 *	joueur dans la list de joueurs.
	 * </p>
	 * <p>
	 * NOTE : la verification dans cette m�thode est secondaire car une
	 * V�rification est d�j� faite dans le Contr�leur en utilisant les m�me
	 * standard.
	 * </p>
	 * @return
	 * 
	 * @see Joueur
	 * @see MainApp#connection
	 * 
	 * @see Joueur#hashCode()
	 * @see Joueur#setId()
	 * 
	 * @see ErrorCode
	 * @see AppControler
	 * 
	 * @since 1.2
	 */
	public ErrorCode inscription() {
		Joueur newPlayer;
		String firstName;
		String lastName;
		String username;
		String password;
		Calendar birthDate;
		StringTokenizer birthDateString;
		int day, month, year;
		
		firstName = AppControler.getInscriptionFirstname();
		
		if (!Joueur.isFirstNameValid(firstName)) {
			return ErrorCode.UNVALID_NAME;
		}
			
		lastName = AppControler.getInscriptionLastname();
		
		if (!Joueur.isLastNameValid(lastName)) {
			return ErrorCode.UNVALID_NAME;
		}

		birthDateString =
				new StringTokenizer(AppControler.getInscriptionBirthDate());
		try {
			day = Integer.parseUnsignedInt(birthDateString.nextToken());
			month = Integer.parseUnsignedInt(birthDateString.nextToken());
			year = Integer.parseUnsignedInt(birthDateString.nextToken());
		} catch (NoSuchElementException e) {
			day = -1;
			month = -1;
			year = -1;
		}
		
		birthDate = Joueur.checkDate(year, month, day);
		
		if (birthDate == null) {
			return ErrorCode.UNVALID_DATE_FORMAT;
		}
		
		username = AppControler.getInscriptionUsername();

		if (players.containsKey(Joueur.hashCode(username))) {
			return ErrorCode.UNAVALABLE_USERNAME;
		}
		
		password = AppControler.getInscriptionPassword();
		
		if (!Joueur.isPasswordValid(password)) {
			return ErrorCode.UNVALID_PASSWORD;
		}
		
		if (Calendar.getInstance().get(Calendar.YEAR)
				- (birthDate.get(Calendar.YEAR))
			> 18) { // le joueur est adulte
			
			newPlayer = new Adulte(
					firstName,
					lastName,
					username,
					password,
					birthDate.getTime()
				);
		} else {
			newPlayer = new Enfant(firstName,
					lastName,
					username,
					password,
					birthDate.getTime()
				);
		}
		
		//Pour des raisons de s�curit� on efface le mot de passe
		password = new String("");
		
		currnetPlayer = newPlayer;
		players.put(newPlayer.getId(), newPlayer);
		
		return ErrorCode.NO_ERROR;
	}
	
	/**
	 * <p>
	 * 	V�rifie que tout c'est bien pass� et enregistres les nouvelles donn�es
	 * 	dans les fichiers de sauvegarde.
	 * </p>
	 */
	public void terminate() {
		File playerFile = new File("resources\\save\\player.sve");
		File themeFile = new File("resources\\save\\themes.sve");
		
		try {
			playerFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			themeFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			ObjectOutputStream playerFileOut =
					new ObjectOutputStream(new FileOutputStream(playerFile));
			
			if (playerFileOut != null && !players.isEmpty()) {
				playerFileOut.writeObject(players);
			}
			
			try {
				playerFileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			ObjectOutputStream themeFileOut =
					new ObjectOutputStream(new FileOutputStream(themeFile));
			
			if (themeFileOut != null && !themes.isEmpty()) {
				themeFileOut.writeObject(themes);
			}
			
			try {
				themeFileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args - non utilis�.
	 */
	public static void main(String[] args) {
		AppControler.start();
	}

	public Joueur getCurrentPlayer() {
		return currnetPlayer;
	}


	public PartieJeu getCurrentGame() {
		return currentGame;
	}


	public void setCurrentGame(PartieJeu currentGame) {
		this.currentGame = currentGame;
	}


	public HashSet<ThemeJeu> getThemes() {
		return themes;
	}

	/**
	 * <b>S\occupe de retourner les information des joueurs sous forme de liste
	 * de String</b>
	 * @return une liste contenant les information des joueurs (on a fait
	 * attention a ne retourner que le minimum n�cessaire afin de preserver les
	 * informations des joueurs)
	 */
	public ArrayList<String> getPlayers() {
		Set<Integer> keySet = players.keySet();
		ArrayList<String> players = new ArrayList<String>();
		int i = 1;
		

		int previousMax = Integer.MAX_VALUE;
		Joueur previousMaxPlayer = null;
		
		//un tri des joueur selon leur scores
		while(players.size() < keySet.size()) {
			int maxScore = 0;
			int maxKey = 0;

			for(Integer key : keySet) {
				if (this.players.get(key).getTotalScore() >= maxScore
					&& this.players.get(key).getTotalScore() <= previousMax
					&& !this.players.get(key).equals(previousMaxPlayer)) {
					
					maxKey = key;
					maxScore = this.players.get(key).getTotalScore();
				}
			}
			
			players.add(i + "    " + this.players.get(maxKey).toString());
			previousMax = maxScore;
			previousMaxPlayer = this.players.get(maxKey);
			i++;
		}
		
		return players;
	}
}
