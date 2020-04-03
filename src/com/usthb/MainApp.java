package com.usthb;

import java.util.HashMap;
import java.util.HashSet;

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
 * @version 1.0
 */
public class MainApp {
	/**
	 * <p>
	 * 	Contient tous les joueurs inscrits auparavant, sera initialis� � partir
	 *  d'un ficher contenant ces derniers. Voir la documentation de 
	 *  l'initialisation pour plus de d�tails.
	 * </p>
	 * 
	 * @see MainApp#initialization()
	 * @see com.usthb.modeles.Joueur
	 */
	private static HashMap<Integer, Joueur> players;
	
	/**
	 * <p>
	 * 	Contient tous les th�mes disponibles, sera initialis� � partir de deux
	 * 	fichiers diff�rents : un contenant les th�mes, l'autre les questions. Voir la
	 * 	m�thode initialisation pour plus de d�tails
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
	 * 	Se lance d�s le lancement du jeu pour pr�parer les �l�ments et donn�es
	 * 	n�cessaires en faisant ce qui suit :
	 * </p>
	 * <ol>
	 * 	<li>
	 * 		Ouvre la fenêtre de chargement
	 * 		//TODO donner plus de d�tailles sur ce point
	 * 	</li>
	 * 	<li>
	 * 		R�cup�re les joueurs depuis un fichier en utilisant la m�thode 
	 * 		Joueur.readFile() et les met dans la liste des joueurs. Pour plus de
	 * 		d�tails voir la documentation de Joueur.readFile()
	 *	</li>
	 * 	<li>
	 * 		R�cup�re les th�mes depuis un ficher en utilisant la m�thode
	 * 		ThemeJeu.readFile et les mets dans la list des th�mes. Pour plus de
	 *		d�tails voir la documentation de ThemeJeu.readFile
	 * 	</li>
	 * 	<li>
	 * 		ferme la fenêtre de chargement et ouvre la fenêtre principale
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
	 * 	Prends un nom d'utilisateur et un mot de passe, g�n�re un id unique en
	 * 	utilisant la m�thode Joueur.setId puis en utilisant cet id comme cl�
	 *  acc�de aux donn�es du joueur, v�rifie que le user name concorde avec
	 *  celui donn�. Si c'est le cas, verifie que le mot de passe est
	 *  correct. Si c'est le cas, acc�de � la page pour lancer une partie sinon
	 *  dit que le mot de passe est faux
	 *  TODO g�rer le cas si le nom d'utilisateur donn� et celui trouv� ne sont pas les mêmes
	 * </p>
	 * @return les donn�es du joueur sous forme de Joueur, voir la documentation
	 * de la class Joueur pour plus de d�tails
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
					//la condition v�rifie si le nom d'utilisateur donn� est
					//le même que celui trouv� dans la liste des joueurs
					if (players.get(playerConnecting.getId()).getPassword().equals(password)) {
						//la condition v�rifie si le nom mot de passe donn� est
						//le même que celui trouv� dans la liste des joueurs
						playerConnecting = players.get(playerConnecting.getId());
					}
				}//le cas où le nom d'utilisateur ne correspond pas n'est pas
				 //possible car on v�rifie toujours que l'id n'existe pas avant
				 //d'ajouter un nouveau joueur. On ajoute jamais un username
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
	 * @param args - non utilis�.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
