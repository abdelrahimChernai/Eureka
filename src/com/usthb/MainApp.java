
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
	 * 	Contient tout les joueurs inscrit auparavant, sera initialis� � partir
	 *  d'un ficher contenant ces dernier voir la documentation de 
	 *  initialisation pour plus de d�tailles.
	 * </p>
	 * 
	 * TODO add a link to initialisation
	 * @see com.usthb.modeles.Joueur
	 */
	private static HashMap<Integer, Joueur> players;
	
	/**
	 * <p>
	 * 	Contient tout les themes disponibles, sera initialis� � partir de deux
	 * 	fichier diff�rant un contenant les themes l'autes les questions voir la
	 * 	m�thode initialisation pour plus de d�tailles
	 * </p>
	 * 
	 * @see com.usthb.modeles.ThemeJeu
	 * @see com.usthb.modeles.Question
	 */
	private static HashSet<ThemeJeu> themes;
	
	/**
	 * <p>
	 * 	Se lance d�s le lancement du jeu pour preparer les �l�ments et donn�es
	 * 	n�cessaire en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fen�tre de chargement
	 * 		//TODO donner plus de d�tailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		R�cup�re les joueurs depuis un fichier en utilisant la m�thode 
	 * 		Joueur.readFile() et les met dans la list des joueurs pour plus de
	 * 		d�tailles voir la documentation de Joueur.readFile()
	 *	</li>
	 * 	<li>
	 * 		R�cup�re les themes depuis un ficher en utilisant la m�thode
	 * 		ThemeJeu.readFile et les met dans la list des themes pour plus de
	 *		d�tailles voir la documentation de ThemeJeu.readFile
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
	 * 	prends un nom d'utilisateur et un mot de pass, genre un id unique en
	 * 	utilisant la m�thode Joueur.setId puis en utilisant cet id comme cl�
	 *  accede au donn�e du joueurs versifie que le user name concorde avec
	 *  celui donn�e puis si c'est le cas verifies que le mot de pass est
	 *  correct si c'est le cas accede � la page pour lancer une partie sinon
	 *  dis que le mot de passe est faux
	 *  TODO g�rer le cas si le nom d'utilisateur donn� et celui trouv� ne sont pas les m�me
	 * </p>
	 * @return les donn�es du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de d�tailles
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
					//la condition v�rifie si le nom d'utilisateur donn�e est
					//le m�me que celui trouv� dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(playerConnecting.getPassword())) {
						//la condition v�rifie si le nom mot de pass donn�e est
						//le m�me que celui trouv� dans la liste des joueurs
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
