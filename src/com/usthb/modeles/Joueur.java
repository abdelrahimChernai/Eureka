/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;

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
	}
	
	/**
	 * R�cup�r�e le num�ro s�quentiel du joueur
	 * @return num�ro s�quentiel du joueur
	 */
	public int getId() {
		return this.id;
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