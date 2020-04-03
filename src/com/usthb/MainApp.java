package com.usthb;

import java.util.HashMap;
import java.util.HashSet;

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
 * @version 1.0
 */
public class MainApp {
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
	private static HashMap<Integer, Joueur> players;
	
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
	 * 	Prends un nom d'utilisateur et un mot de passe, génère un id unique en
	 * 	utilisant la méthode Joueur.setId puis en utilisant cet id comme clé
	 *  accède aux données du joueur, vérifie que le user name concorde avec
	 *  celui donné. Si c'est le cas, verifie que le mot de passe est
	 *  correct. Si c'est le cas, accède à la page pour lancer une partie sinon
	 *  dit que le mot de passe est faux
	 *  TODO gérer le cas si le nom d'utilisateur donné et celui trouvé ne sont pas les mÃªmes
	 * </p>
	 * @return les données du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de détails
	 * 
	 * @see com.usthb.modeles.Joueur
	 * 
	 * @see com.usthb.modeles.Joueur#hashCode()
	 * @see com.usthb.modeles.Joueur#id
	 * @see com.usthb.modeles.Joueur#setId()
	 */
	private static Joueur connection(String username, String password) {
		Joueur playerConnecting = new Joueur();
		
		do {
			//TODO read the player's user name
			playerConnecting.setUsername(username);
			//TODO read the player password
			playerConnecting.setPassword(password);
			playerConnecting.setId();
			
			if (players.containsKey(playerConnecting.getId())) {
				if (players.get(playerConnecting.getId()).getUsername().equals(username)) {
					//la condition vérifie si le nom d'utilisateur donné est
					//le mÃªme que celui trouvé dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(password)) {
						//la condition vérifie si le nom mot de passe donné est
						//le mÃªme que celui trouvé dans la liste des joueurs
						playerConnecting = players.get(playerConnecting.getId());
					}
				}//le cas oÃ¹ le nom d'utilisateur ne correspond pas n'est pas
				 //possible car on vérifie toujours que l'id n'existe pas avant
				 //d'ajouter un nouveau joueur. On ajoute jamais un username
				 //directement.
			}
		} while(playerConnecting.getFirstName().equals(""));
		
		return playerConnecting;
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
		do {
			//TODO read the first name and put it in the newPlayer variable
			//TODO read the last name and put it in the newPlayer variable
			//TODO read the birth Day and put it in the newPlayer variable
			//TODO read the user name and put it in the newPlayer variable
		} while (players.containsKey(newPlayer.hashCode()));
			//TODO read the password and put it in the newPlayer variable
			//TODO read it again to check the password and put it in the newPlayer variable

			return MainApp.connection(newPlayer.getUsername(), newPlayer.getPassword());
	}

	/**
	 * @param args - non utilisé.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
