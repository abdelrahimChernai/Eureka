package com.usthb;

import java.util.HashMap;
import java.util.HashSet;

import com.usthb.modeles.Joueur;
import com.usthb.modeles.ThemeJeu;

/**
 * <b>
 *  MainApp est la classe contenant le point d'entr�e du programme donc elle
 * 	repr�sente l'application
 * </b>
 * <p>
 *	S'ocupe l'orientation de l'enchainements des �v�nements pour qu'ils soit
 *	traiter en envoyant chaque �v�nements a la class qui s'occupe de le g�rer
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
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
	 * 	Prends un nom d'utilisateur et un mot de pass, g�n�re un id unique en
	 * 	utilisant la m�thode Joueur.setId puis en utilisant cet id comme cl�
	 *  accede au donn�e du joueurs versifie que le user name concorde avec
	 *  celui donn�e puis si c'est le cas verifies que le mot de pass est
	 *  correct si c'est le cas accede à la page pour lancer une partie sinon
	 *  dis que le mot de passe est faux
	 *  TODO g�rer le cas si le nom d'utilisateur donn� et celui trouv� ne sont pas les m�me
	 * </p>
	 * @return les donn�es du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de d�tailles
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
					//la condition v�rifie si le nom d'utilisateur donn�e est
					//le m�me que celui trouv� dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(password)) {
						//la condition v�rifie si le nom mot de pass donn�e est
						//le m�me que celui trouv� dans la liste des joueurs
						playerConnecting = players.get(playerConnecting.getId());
					}
				}//le cas ou le nom d'utilisateur ne correspond pas n'est pas
				 //possible car on v�rifie toujours que l'id n'existe pas avant
				 //ajoute d'un nouveau joueur et on ajoute jamais un username
				 //directement.
			}
		} while(playerConnecting.getFirstName().equals(""));
		
		return playerConnecting;
	}
	
	/**
	 * <p>
	 *	Lie le Nom, Pr�nom, date de naissance, un nom d'utilisateur puis cr�e
	 *	un id et v�rifie qu'il n'existe pas dans la liste des joueurs puis lie
	 *	un mot de passe et demande de le confirmer, cette m�thode v�rifie que
	 *	les entr�es sont conforme au norme utilis� dans le code voir la
	 *	documentation de Joueur pour plus de d�tailles. une fois que les donn�s
	 *	initialis� le joueur est ajout� a la liste des joueurs puis on appelle
	 *	la m�thode connection pour le connecter et lui proposer de commencer une
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
	 * @param args - non utilis�.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
