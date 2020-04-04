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
 * @version 1.1.0
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
	 * @see MainApp#initialization()
	 * @see com.usthb.modeles.Joueur
	 */
	private static HashMap<Integer, Joueur> players = new HashMap<Integer, Joueur>();		// TODO add initialisation in fix
	
	/**
	 * <p>
	 * 	Contient tous les thèmes disponibles, sera initialisé à partir de deux
	 * 	fichiers différents : un contenant les thèmes, l'autre les questions. Voir la
	 * 	méthode initialisation pour plus de détails
	 * </p>
	 * 
	 * @see com.usthb.modeles.ThemeJeu
	 * @see com.usthb.modeles.Question
	 * 
	 * @see MainApp#initialization()
	 */
	private static HashSet<ThemeJeu> themes;
	
	/**
	 * <p>
	 * 	Se lance dès le lancement du jeu pour préparer les éléments et données
	 * 	nécessaires en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fenÃªtre de chargement
	 * 		//TODO donner plus de détailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		Récupère les joueurs depuis un fichier en utilisant la méthode 
	 * 		Joueur.readFile() et les met dans la liste des joueurs. Pour plus de
	 * 		détails voir la documentation de Joueur.readFile()
	 *	</li>
	 * 	<li>
	 * 		Récupère les thèmes depuis un ficher en utilisant la méthode
	 * 		ThemeJeu.readFile et les mets dans la list des thèmes. Pour plus de
	 *		détails voir la documentation de ThemeJeu.readFile
	 * 	</li>
	 * 	<li>
	 * 		ferme la fenÃªtre de chargement et ouvre la fenÃªtre principale
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
<<<<<<< HEAD
	 * 	Prends un nom d'utilisateur et un mot de passe, génère un id unique en
	 * 	utilisant la méthode Joueur.setId puis en utilisant cet id comme clé
	 *  accède aux données du joueur, vérifie que le user name concorde avec
	 *  celui donné. Si c'est le cas, vérifie que le mot de passe est
	 *  correct. Si c'est le cas, accède à la page pour lancer une partie sinon
	 *  dit que le mot de passe est faux
	 *  TODO gérer le cas si le nom d'utilisateur donné et celui trouvé ne sont pas les mêmes
=======
	 * 	Demande un nom d'utilisateur vérifie si l'id généré par ce dernier
	 * 	existe sinon se répète jusau'à insertion d'un nom d'utilisateur valide
	 * 	puis demande un mot de passe jusqu'au l'insertion du mot de passe
	 * 	correspondant au profile représenté par le nom d'utilisateur, puis, une
	 * 	fois que le bon mot de passe est inséré, retourne les données du joueur.
>>>>>>> testJoueur
	 * </p>
	 * @return les données du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de détails
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see com.usthb.modeles.Joueur#hashCode()
	 * @see com.usthb.modeles.Joueur#id
	 * @see com.usthb.modeles.Joueur#setId()
	 * 
	 * @since 1.1.0
	 */
	private static Joueur connection() {
		Joueur playerConnecting = new Joueur();

		do {
			System.out.println("username");
			playerConnecting.setUsername(console.nextLine());
			playerConnecting.setId();
			
			if (players.containsKey(playerConnecting.getId())) {
				System.out.println("Hello " + playerConnecting.getUsername() + "!");
			} else {
				System.out.println("Sure about that ?");
			}
			
		} while (! players.containsKey(playerConnecting.getId()));
		
		do {
			System.out.println("password");
			playerConnecting.setPassword(console.nextLine());
			if (players.get(playerConnecting.getId()).getPassword().equals(playerConnecting.getPassword())) {
				System.out.println("You are loged in");
			} else {
				System.out.println("Wrong the password is, my young padawan");
			}
		} while (! players.get(playerConnecting.getId()).getPassword().equals(playerConnecting.getPassword()));
		
			
		return players.get(playerConnecting.getId());
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
	 */
	private static Joueur inscription() {
		Joueur newPlayer = new Joueur();
		
		System.out.println("first name");
		newPlayer.setFirstName(console.nextLine());
			
		System.out.println("last name");
		newPlayer.setLastName(console.nextLine());

		System.out.println("Birth date YYYY MM DD");
		newPlayer.setBirthDate(new Date(console.nextInt() - 1900, console.nextInt() - 1, console.nextInt()));
		console.nextLine();
		
		do {
			System.out.println("username");
			newPlayer.setUsername(console.nextLine());
			
			if (players.containsKey(newPlayer.hashCode())) {
				System.out.println("this one is not avalable, try somthing else");
			} else {
				System.out.println("Alright " + newPlayer.getUsername() + " it is !");
				newPlayer.setId();
			}
		} while (players.containsKey(newPlayer.hashCode()));
		
		System.out.println("password");
		newPlayer.setPassword(console.nextLine());
		//TODO read it again to check the password and put it in the newPlayer variable
		
		players.put(newPlayer.getId(), newPlayer);

			return newPlayer;
	}

	/**
	 * @param args - non utilisé.
	 */
	public static void main(String[] args) {
		Joueur p1, p2;
		
		p1 = inscription();
		System.out.println(p1);

		p2 = connection();
			
		System.out.println(p2);

		console.close();
	}
}
