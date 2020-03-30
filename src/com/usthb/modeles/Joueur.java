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
	 * A list of games played by the layer since his inscription.
	 * 
	 * @see PartieJeu
	 */
	protected LinkedList<PartieJeu> playerGames;
	
	public Joueur() {
		
	}
	
	public int getTotalScore() {
		int totalScore = 0;
		
		for (PartieJeu game : this.playerGames) {
			totalScore += game.score;
		}
		return totalScore;
	}
	
}