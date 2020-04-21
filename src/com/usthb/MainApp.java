package com.usthb;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.usthb.modeles.Joueur;
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
	static Scanner console = new Scanner(System.in);		// TEST
	
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
	private static HashMap<Integer, Joueur> players =
		new HashMap<Integer, Joueur>();
	
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
	private static HashSet<ThemeJeu> themes;
	
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
	 * 		R�cup�re les joueurs depuis un fichier en utilisant la m�thode 
	 * 		Joueur.readFile() et les met dans la liste des joueurs. Pour plus
	 * 		de d�tails voir la documentation de Joueur.readFile().
	 *	</li>
	 * 	<li>
	 * 		R�cup�re les th�mes depuis un ficher en utilisant la m�thode
	 * 		ThemeJeu.readFile et les mets dans la list des th�mes. Pour plus de
	 *		d�tails voir la documentation de ThemeJeu.readFile
	 * 	</li>
	 * 	<li>
	 * 		ferme la fen�tre de chargement et ouvre la fen�tre principale
	 * 		//TODO donner plus de d�tailles sur ce point
	 * 	</li>
	 * <ol>
	 * 
	 * //TODO add a link to Joueur.readFile
	 * //TODO add a link to Theme.readFile
	 * @see MainApp#themes
	 * @see MainApp#players
	 */
	private static void initialization() {
		
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
	public static Joueur connection() {
		String username;
		String password;
		
		do {
			System.out.println("username");
			username = console.nextLine();
			
			if (players.containsKey(Joueur.hashCode(username))) {
				System.out.println("Hello " + username + "!");
			} else {
				System.out.println("Sure about that ?");
			}
			
		} while (! players.containsKey(Joueur.hashCode(username)));
		
		do {
			System.out.println("password");
			password = console.nextLine();
			
			if (players.get(Joueur.hashCode(username)).getPassword().equals(password)) {
				System.out.println("You are loged in");
			} else {
				System.out.println("Wrong the password is, my young padawan");
			}
		} while (! players.get(Joueur.hashCode(username)).getPassword().equals(password));
		
			
		return players.get(Joueur.hashCode(username));
	}
	
	/**
	 * <p>
	 *	Lie le Nom, Pr�nom, date de naissance, un nom d'utilisateur puis cr�e
	 *	un id et v�rifie qu'il n'existe pas dans la liste des joueurs puis lie
	 *	un mot de passe et demande de le confirmer, cette m�thode v�rifie que
	 *	les entr�es sont conforme aux normes utilis�es dans le code. Voir la
	 *	documentation de Joueur pour plus de d�tails. Une fois que les donn�es
	 *	initialis�es, le joueur est ajout� a la liste des joueurs puis on appelle
	 *	la m�thode connexion pour le connecter et lui propose de commencer une
	 *	partie. Voir la documentation de MainApp.connection
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
	public static void inscription() {
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
		
		newPlayer = new Joueur(firstName, lastName, username, password, birthDate);
		players.put(newPlayer.getId(), newPlayer);
	}

	/**
	 * @param args - non utilis�.
	 */
	public static void main(String[] args) {
		Joueur currentPlayer;
		
		inscription();
		currentPlayer = connection();
		System.out.println(currentPlayer);

		console.close();
	}
}
