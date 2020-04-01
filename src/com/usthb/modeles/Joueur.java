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
		this.playerGames = null;
	}
	
	/**
	 * Récupérée le numéro séquentiel du joueur
	 * @return numéro séquentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Initialise le numéro séquentiel du joueur a un entier
	 * <p>
	 * 	Note : l'unisité du id dans la liste des en joueurs avant d'utiliser
	 *  cette méthode 
	 * </p>
	 */
	public void setId() {
		this.id = this.hashCode();
	}
	
	/**
	 * <p>
	 * Utilise la fonction de Objects pour créer un Numéro séquentiel et
	 * utilise la fonction Math.Abs pour s'asuere que id >= 0 vu qu'il est
	 * utilisé pour accéder à la liste des joueurs voir les méthodes connection
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
	 * <p>
	 * Initialise le nom d'utilisateur au nom donnée, ce username doit être
	 * unique et son unicité est verifier a travers l'inicité du id généré voir
	 * les méthodes Joueur.setId() et Joueur.hashCode
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