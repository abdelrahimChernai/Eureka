/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

import com.usthb.MainApp;

/**
 * @author Abdelrahim Chernai
 * @version 2.0
 */
public class Joueur {
	protected int id;					//Num�ro s�quentiel automatique.
	
	/**
	 * Le niveau le plus ressent du joueur atteint lors de derni�re partie jou�.
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels currentLvl;
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Pr�nom du joueur.
	protected String username;			//Nom d'utilisateur.
	protected String password;			//Mot de passe.
	protected Date birthDate;			//Date de naissance.
	
	/**
	 * A list of games played by the player since his inscription.
	 * 
	 * @see PartieJeu
	 */
	protected LinkedList<PartieJeu> playerGames;
	
	public Joueur() {
		this.id = -1;		//Pour ne pas acc�der a un joueur si on initialize
							//pas cet variable d'instance
		
		this.firstName = "";//On utilise ce parameter pour verifier que le
							//joueur n'est pas initialis�
		this.playerGames = null;
	}
	
	/**
	 * R�cup�r�e le num�ro s�quentiel du joueur
	 * @return num�ro s�quentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Initialise le num�ro s�quentiel du joueur a un entier
	 * <p>
	 * 	Note : l'unisit� du id dans la liste des en joueurs avant d'utiliser
	 *  cette m�thode 
	 * </p>
	 */
	public void setId() {
		this.id = this.hashCode();
	}
	
	/**
	 * <p>
	 * Utilise la fonction de Objects pour cr�er un Num�ro s�quentiel et
	 * utilise la fonction Math.Abs pour s'asuere que id >= 0 vu qu'il est
	 * utilis� pour acc�der � la liste des joueurs voir les m�thodes connection
	 * et inscription
	 * </p>
	 * 
	 * @return an id that identifies the player
	 * 
	 * @see com.usthb.MainApp#connection()
	 * @see com.usthb.MainApp#inscription()
	 */
	public int hashCode() {
		return Math.abs(Objects.hash(this.username));
	}

	/**
	 * R�cup�r�e le pr�nom du joueur
	 * @return Le pr�nom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	
	/**
	 * R�cup�r�e le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * <p>
	 * Initialise le nom d'utilisateur au nom donn�e, ce username doit �tre
	 * unique et son unicit� est verifier a travers l'inicit� du id g�n�r� voir
	 * les m�thodes Joueur.setId() et Joueur.hashCode
	 * </p>
	 * @param username le nom d'utilisateur qu'on veut affecter
	 * 
	 * @see Joueur
	 * 
	 * @see Joueur#hashCode()
	 * @see Joueur#setId()
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * R�cup�r�e le mot de pass du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale de la list partie jou�.
	 * 
	 * @see PartieJeu
	 * 
	 * @see Joueur#playerGames
	 */
	public int getTotalScore() {
		int totalScore = 0;
		
		for (PartieJeu game : this.playerGames) {
			totalScore += game.score;
		}
		return totalScore;
	}
}