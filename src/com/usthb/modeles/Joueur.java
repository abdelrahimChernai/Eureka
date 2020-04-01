package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * <b>Joueur est la class représentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @version 2.0
 * @see ParieJeu
 */
public class Joueur {
  
  /**
	 * <p>
	 * 	Numéro séquentiel automatique unique caractérisant le joueur et utilisé
	 *  comme clé pour accéder au information du joueur dans la list des 
	 *  joueurs.
	 * </p>
	 * <p>
	 * 	Pour plus d'information sur la list des joueur voir la documentation de
	 *  la class MainApp.
	 * </p>
	 * 
	 * @see com.usthb.MainApp
	 */
	protected int id;
	
	/**
   * <p>
	 *  Le niveau le plus ressent du joueur atteint lors de dernière partie joué
   *  chaque niveau passé donne un certain nombre de point et permet au joueur
   *  de reprendre Ã§a partie au même niveau.
	 * </p>
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels currentLvl;
  
	/**
	 * <p>
	 * 	Représente le Nom du joueur, est demandé lors de son inscription
	 * </p>
	 */
	protected String lastName;
  
	/**
	 * <p>
	 * 	Représente le Prénom du joueur, est demandé lors de son inscription
	 * </p>
	 */
	protected String firstName;
  
	/**
	 * <p>
	 * 	Le nom d'utilisateur Ã  partir du quel on génère un id unique cette
	 * 	unicité est assuré car lors de la récupération de ce nom d'utilisateur
	 * 	une génère un id et on vérifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur de donner un autre, est aussi utilisé lors de la
	 *  connection de joueur.
	 * </p>
	 */
	protected String username;
  
  /**
	 * <p>
	 * 	On l'utilise lors de la connection du joueur pour s'assurer de son
	 * 	identité.
	 * </p>
	 */
	protected String password;
  
  /**
	 * La date de naissance du joueur.
	 */
	protected Date birthDate;
	
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
	 * utilisé pour accéder Ã  la liste des joueurs voir les méthodes connection
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