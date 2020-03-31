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
	protected int id;					//Numéro séquentiel automatique.
	
	/**
	 * Le niveau le plus ressent du joueur atteint lors de dernière partie joué.
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels currentLvl;
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Prénom du joueur.
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
		this.id = -1;		//Pour ne pas accéder a un joueur si on initialize
							//pas cet variable d'instance
		
		this.firstName = "";//On utilise ce parameter pour verifier que le
							//joueur n'est pas initialisé
	}
	
	/**
	 * Récupérée le numéro séquentiel du joueur
	 * @return numéro séquentiel du joueur
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Récupérée le prénom du joueur
	 * @return Le prénom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	
	/**
	 * Récupérée le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Récupérée le mot de pass du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale de la list partie joué.
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