package com.usthb;

import java.util.HashMap;
import java.util.HashSet;

import com.usthb.modeles.Joueur;
import com.usthb.modeles.ThemeJeu;

/**
 * <b>
 *  MainApp est la classe contenant le point d'entrée du programme donc elle
 * 	représente l'application
 * </b>
 * <p>
 *	S'ocupe l'orientation de l'enchainements des évènements pour qu'ils soit
 *	traiter en envoyant chaque événements a la class qui s'occupe de le gérer
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class MainApp {
	/**
	 * <p>
	 * 	Contient tout les joueurs inscrit auparavant, sera initialisé à partir
	 *  d'un ficher contenant ces dernier voir la documentation de 
	 *  initialisation pour plus de détailles.
	 * </p>
	 * 
	 * TODO add a link to initialisation
	 * @see com.usthb.modeles.Joueur
	 */
	private static HashMap<Integer, Joueur> players;
	
	/**
	 * <p>
	 * 	Contient tout les themes disponibles, sera initialisé à partir de deux
	 * 	fichier différant un contenant les themes l'autes les questions voir la
	 * 	méthode initialisation pour plus de détailles
	 * </p>
	 * 
	 * @see com.usthb.modeles.ThemeJeu
	 * @see com.usthb.modeles.Question
	 */
	private static HashSet<ThemeJeu> themes;
	
	/**
	 * <p>
	 * 	Se lance dés le lancement du jeu pour preparer les éléments et données
	 * 	nécessaire en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fenêtre de chargement
	 * 		//TODO donner plus de détailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		Récupère les joueurs depuis un fichier en utilisant la méthode 
	 * 		Joueur.readFile() et les met dans la list des joueurs pour plus de
	 * 		détailles voir la documentation de Joueur.readFile()
	 *	</li>
	 * 	<li>
	 * 		Récupère les themes depuis un ficher en utilisant la méthode
	 * 		ThemeJeu.readFile et les met dans la list des themes pour plus de
	 *		détailles voir la documentation de ThemeJeu.readFile
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
	 * 	Prends un nom d'utilisateur et un mot de pass, génère un id unique en
	 * 	utilisant la méthode Joueur.setId puis en utilisant cet id comme clé
	 *  accede au donnée du joueurs versifie que le user name concorde avec
	 *  celui donnée puis si c'est le cas verifies que le mot de pass est
	 *  correct si c'est le cas accede Ã  la page pour lancer une partie sinon
	 *  dis que le mot de passe est faux
	 *  TODO gérer le cas si le nom d'utilisateur donné et celui trouvé ne sont pas les méme
	 * </p>
	 * @return les données du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de détailles
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
			//TODO read the player password and put it in playerConnecting variable
			playerConnecting.hashCode();
			playerConnecting.setId();
			
			if (players.containsKey(playerConnecting.getId())) {
				if (players.get(playerConnecting.getId()).getUsername().equals(username)) {
					//la condition vérifie si le nom d'utilisateur donnée est
					//le même que celui trouvé dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(password)) {
						//la condition vérifie si le nom mot de pass donnée est
						//le même que celui trouvé dans la liste des joueurs
						playerConnecting = players.get(playerConnecting.getId());
					}
				}//le cas ou le nom d'utilisateur ne correspond pas n'est pas
				 //possible car on vérifie toujours que l'id n'existe pas avant
				 //ajoute d'un nouveau joueur et on ajoute jamais un username
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
	 *	les entrées sont conforme au norme utilisé dans le code voir la
	 *	documentation de Joueur pour plus de détailles. une fois que les donnés
	 *	initialisé le joueur est ajouté a la liste des joueurs puis on appelle
	 *	la méthode connection pour le connecter et lui proposer de commencer une
	 *	partie voir la documentation de MainApp.connection
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
		Joueur newPlayer= new Joueur();
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
