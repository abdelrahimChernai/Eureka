
package com.usthb;

import java.util.HashMap;
import java.util.HashSet;

import com.usthb.modeles.Joueur;
import com.usthb.modeles.ThemeJeu;

/**
 * @author Abdelrahim Chernai
 *
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
	 * 	Se lance dès le lancement du jeu pour preparer les éléments et données
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
	 * 	prends un nom d'utilisateur et un mot de pass, genre un id unique en
	 * 	utilisant la méthode Joueur.setId puis en utilisant cet id comme clé
	 *  accede au donnée du joueurs versifie que le user name concorde avec
	 *  celui donnée puis si c'est le cas verifies que le mot de pass est
	 *  correct si c'est le cas accede à la page pour lancer une partie sinon
	 *  dis que le mot de passe est faux
	 *  TODO gérer le cas si le nom d'utilisateur donné et celui trouvé ne sont pas les même
	 * </p>
	 * @return les données du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de détailles
	 * 
	 * @see com.usthb.modeles.Joueur
	 * @see com.usthb.modeles.Joueur#id
	 * TODO add a link to Joueur.setId 
	 */
	private static Joueur connection() {
		Joueur playerConnecting = new Joueur();
		
		do {
			//TODO read the player's user name and put it in playerConnecting variable
			//TODO read the player password and put it in playerConnecting variable
			//TODO generate the player id and put it in playerConnecting variable
			
			if (players.containsKey(playerConnecting.getId())) {
				if (players.get(playerConnecting.getId()).getUsername().equals(playerConnecting.getUsername())) {
					//la condition vérifie si le nom d'utilisateur donnée est
					//le même que celui trouvé dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(playerConnecting.getPassword())) {
						//la condition vérifie si le nom mot de pass donnée est
						//le même que celui trouvé dans la liste des joueurs
						playerConnecting = players.get(playerConnecting.getId());
					}
				}//TODO  le cas ou le nom d'utilisateur ne correspond pas 
			}
		} while(playerConnecting.getFirstName().equals(""));
		
		return playerConnecting;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
