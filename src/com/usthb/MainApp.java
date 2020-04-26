package com.usthb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.usthb.controler.AppControler;
import com.usthb.modeles.Joueur;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.ThemeJeu;

/**
 * <b>
 *  MainApp est la classe contenant le point d'entr�e du programme donc elle
 *  repr�sente l'application
 * </b>
 * <p>
 *	S'ocupe d'orienter l'enchainement des �v�nements pour qu'ils soient trait�s
 *	en envoyant chaque �v�nement � la classe qui s'occupe de le g�rer
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.1
 */
public class MainApp {
	public static Scanner console = new Scanner(System.in);		// TEST
	
	private Joueur currnetPlayer;
	
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
	
	
	
	public MainApp() {
		this.players = new HashMap<Integer, Joueur>();
		this.themes = new HashSet<ThemeJeu>();
		this.currnetPlayer = null;
	}


	/**
	 * <p>
	 * 	Se lance d�s le lancement du jeu pour pr�parer les �l�ments et donn�es
	 * 	n�cessaires en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fen�tre de chargement
	 * 		//TODO donner plus de d�tailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		R�cup�re la liste des joueurs depuis un fichier et la list des 
	 * 		th�mes.
	 *	</li>
	 * 	<li>
	 * 		ferme la fen�tre de chargement et ouvre la fen�tre principale
	 * 		//TODO donner plus de d�tailles sur ce point
	 * 	</li>
	 * <ol>
	 *
	 * @see MainApp#themes
	 * @see MainApp#players
	 */
	public void initialization() {
		File playerFile = new File("player.sve");
		File themeFile = new File("themes.sve");
		
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
	 * 	Demande un nom d'utilisateur v�rifie si l'id g�n�r� par ce dernier
	 * 	existe sinon se r�p�te jusau'� insertion d'un nom d'utilisateur valide
	 * 	puis demande un mot de passe jusqu'au l'insertion du mot de passe
	 * 	correspondant au profile repr�sent� par le nom d'utilisateur, puis, une
	 * 	fois que le bon mot de passe est ins�r�, retourne les donn�es du
	 * 	joueur.
	 * </p>
	 * @return les donn�es du joueur sous forme de Joueur, voir la
	 * documentation de la class Joueur pour plus de d�tails
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

		if (!players.get(Joueur.hashCode(username)).getPassword().equals(password)) {
			return ErrorCode.WRONG_PASSWORD;
		}
			
		currnetPlayer =  players.get(Joueur.hashCode(username));
		
		return null;
	}
	
	/**
	 * <p>
	 *	Lie le Nom, Pr�nom, date de naissance, un nom d'utilisateur puis cr�e
	 *	un id et v�rifie qu'il n'existe pas dans la liste des joueurs puis lie
	 *	un mot de passe et demande de le confirmer, cette m�thode v�rifie que
	 *	les entr�es sont conforme aux normes utilis�es dans le code. Voir la
	 *	documentation de Joueur pour plus de d�tails. Une fois que les donn�es
	 *	initialis�es, le joueur est ajout� a la liste des joueurs puis on
	 *	appelle la m�thode connexion pour le connecter et lui propose de
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
	@SuppressWarnings("deprecation")
	public void inscription() {
		Joueur newPlayer;
		String firstName;
		String lastName;
		String username;
		String password;
		Date birthDate;
		int day, mounth, year;
		
		System.out.println("first name");
		firstName = console.nextLine();
			
		System.out.println("last name");
		lastName = console.nextLine();

		do {
			System.out.println("Birth date dd mm yyyy");
			day = console.nextInt();
			mounth = console.nextInt() - 1;
			year = console.nextInt() - 1900;
			birthDate = new Date(year, mounth, day);
		} while (! Joueur.isDateValide(birthDate));
			
		console.nextLine();
		
		do {
			System.out.println("username");
			username = console.nextLine();
			
			if (players.containsKey(Joueur.hashCode(username))) {
				System.out.println("this one is not avalable, try somthing else");
			} else {
				System.out.println("Alright " + username + " it is !");
			}
		} while (players.containsKey(Joueur.hashCode(username)));
		
		System.out.println("password");
		password = (console.nextLine());
		System.out.println("confirm password");
		
		while(! console.nextLine().contentEquals(password)) {
			System.out.println("password doesn't match");
		}
		
		newPlayer =
				new Joueur(firstName, lastName, username, password, birthDate);
		players.put(newPlayer.getId(), newPlayer);
	}
	
	/**
	 * <p>
	 * 	V�rifie que tout c'est bien pass� et enregistres les nouvelles donn�es
	 * 	dans les fichiers de sauvegarde.
	 * </p>
	 */
	public void terminate() {
		File playerFile = new File("player.sve");
		File themeFile = new File("themes.sve");
		
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
			
			if (playerFileOut != null) {
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
			
			if (themeFileOut != null) {
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

	public Joueur getCurrnetPlayer() {
		return currnetPlayer;
	}
	
}
