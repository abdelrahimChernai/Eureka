package com.usthb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.usthb.controler.AppControler;
import com.usthb.modeles.Adulte;
import com.usthb.modeles.Enfant;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.ThemeJeu;

/**
 * <b>
 *  MainApp est la classe contenant le point d'entrée du programme donc elle
 *  représente l'application
 * </b>
 * <p>
 *	S'ocupe d'orienter l'enchainement des évènements pour qu'ils soient traités
 *	en envoyant chaque événement à la classe qui s'occupe de le gérer
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.1
 */
public class MainApp {
	
	public static Scanner console = new Scanner(System.in);		// TEST
	
	private Joueur currnetPlayer;
	
	private PartieJeu currentGame;
	
	/**
	 * <p>
	 * 	Contient tous les joueurs inscrits auparavant, sera initialisé à partir
	 *  d'un ficher contenant ces derniers. Voir la documentation de 
	 *  l'initialisation pour plus de détails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see MainApp#initialization()
	 */
	private HashMap<Integer, Joueur> players;
	
	/**
	 * <p>
	 * 	Contient tous les thèmes disponibles, sera initialisé à partir de deux
	 * 	fichiers différents : un contenant les thèmes, l'autre les questions.
	 * 	Voir la méthode initialisation pour plus de détails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.ThemeJeu
	 * @see com.usthb.modeles.Question
	 */
	private HashSet<ThemeJeu> themes;
	
	
	
	public MainApp() {
		this.players = new HashMap<Integer, Joueur>();
		this.themes  = new HashSet<ThemeJeu>();
		this.currnetPlayer = null;
	}


	/**
	 * <p>
	 * 	Se lance dès le lancement du jeu pour préparer les éléments et données
	 * 	nécessaires en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fenêtre de chargement
	 * 		//TODO donner plus de détailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		Récupère la liste des joueurs depuis un fichier et la list des 
	 * 		thèmes.
	 *	</li>
	 * 	<li>
	 * 		ferme la fenêtre de chargement et ouvre la fenêtre principale
	 * 		//TODO donner plus de détailles sur ce point
	 * 	</li>
	 * <ol>
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
	 * 	Demande un nom d'utilisateur vérifie si l'id généré par ce dernier
	 * 	existe sinon se répète jusau'à insertion d'un nom d'utilisateur valide
	 * 	puis demande un mot de passe jusqu'au l'insertion du mot de passe
	 * 	correspondant au profile représenté par le nom d'utilisateur, puis, une
	 * 	fois que le bon mot de passe est inséré, retourne les données du
	 * 	joueur.
	 * </p>
	 * @return les données du joueur sous forme de Joueur, voir la
	 * documentation de la class Joueur pour plus de détails
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see com.usthb.modeles.Joueur#hashCode()
	 * @see com.usthb.modeles.Joueur#id
	 * @see com.usthb.modeles.Joueur#setId()
	 * 
	 * @since 1.1.1
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
	 *	Lie le Nom, Prénom, date de naissance, un nom d'utilisateur puis crée
	 *	un id et vérifie qu'il n'existe pas dans la liste des joueurs puis lie
	 *	un mot de passe et demande de le confirmer, cette méthode vérifie que
	 *	les entrées sont conforme aux normes utilisées dans le code. Voir la
	 *	documentation de Joueur pour plus de détails. Une fois que les données
	 *	initialisées, le joueur est ajouté a la liste des joueurs puis on
	 *	appelle la méthode connexion pour le connecter et lui propose de
	 *	commencer une partie. Voir la documentation de MainApp.connection
	 * </p>
	 * @return
	 * 
	 * @see Joueur
	 * @see MainApp#connection
	 * 
	 * @see Joueur#hashCode()
	 * @see Joueur#setId()
	 * 
	 * @since 1.1.1
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
			System.out.println(birthDate.getTime());
		} else {
			newPlayer = new Enfant(firstName,
					lastName,
					username,
					password,
					birthDate.getTime()
				);
			System.out.println(birthDate.getTime());
		}
		
		//Pour des raisons de sécurité on efface le mot de passe
		password = new String("");
		
		currnetPlayer = newPlayer;
		players.put(newPlayer.getId(), newPlayer);
		
		return ErrorCode.NO_ERROR;
	}
	
	/**
	 * <p>
	 * 	Vérifie que tout c'est bien passé et enregistres les nouvelles données
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
	 * @param args - non utilisé.
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
	
}
