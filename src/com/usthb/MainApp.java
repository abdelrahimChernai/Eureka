package com.usthb;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.usthb.modeles.Joueur;
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
	static Scanner console = new Scanner(System.in);		// TEST
	
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
	private static HashMap<Integer, Joueur> players =
		new HashMap<Integer, Joueur>();
	
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
	private static HashSet<ThemeJeu> themes;
	
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
	 * 		Récupère les joueurs depuis un fichier en utilisant la méthode 
	 * 		Joueur.readFile() et les met dans la liste des joueurs. Pour plus
	 * 		de détails voir la documentation de Joueur.readFile().
	 *	</li>
	 * 	<li>
	 * 		Récupère les thèmes depuis un ficher en utilisant la méthode
	 * 		ThemeJeu.readFile et les mets dans la list des thèmes. Pour plus de
	 *		détails voir la documentation de ThemeJeu.readFile
	 * 	</li>
	 * 	<li>
	 * 		ferme la fenêtre de chargement et ouvre la fenêtre principale
	 * 		//TODO donner plus de détailles sur ce point
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
	 *	Lie le Nom, Prénom, date de naissance, un nom d'utilisateur puis crée
	 *	un id et vérifie qu'il n'existe pas dans la liste des joueurs puis lie
	 *	un mot de passe et demande de le confirmer, cette méthode vérifie que
	 *	les entrées sont conforme aux normes utilisées dans le code. Voir la
	 *	documentation de Joueur pour plus de détails. Une fois que les données
	 *	initialisées, le joueur est ajouté a la liste des joueurs puis on appelle
	 *	la méthode connexion pour le connecter et lui propose de commencer une
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
	 * @param args - non utilisé.
	 */
	public static void main(String[] args) {
		Joueur currentPlayer;
		
		inscription();
		currentPlayer = connection();
		System.out.println(currentPlayer);

		console.close();
	}
}
