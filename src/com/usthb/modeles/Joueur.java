package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * <b>Joueur est la classe représentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 * @see ParieJeu
 */
public class Joueur {
  
  /**
	 * <p>
	 *  Numéro séquentiel automatique unique caractérisant le joueur et utilisé
	 *  comme clé pour accéder aux informations du joueur dans la liste des 
	 *  joueurs.
	 * </p>
	 * <p>
	 * 	Pour plus d'informations sur la liste des joueur, voir la documentation de
	 *  la class MainApp.players
	 * </p>
	 * 
	 * @see com.usthb.MainApp#players
	 */
	protected int id;
	
	/**
   * <p>
	 *  Le niveau le plus récent du joueur est celui atteint lors de dernière partie jouée,
   *  chaque niveau débloqué offre un certain nombre de points et permet au joueur
   *  de reprendre la partie au même niveau.
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
	 * 	Le nom d'utilisateur à  partir duquel on génère un id unique, cette
	 * 	unicité est assuré car lors de la récupération de ce nom d'utilisateur
	 *  on génère un id et on vérifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur d'en saisir un autre, est aussi utilisé lors de la
	 *  connection de joueur.
	 * </p>
	 */
	protected String username;
  
  /**
	 * <p>
	 * 	On l'utilise lors de la connexion du joueur pour s'assurer de son
	 * 	identité.
	 * </p>
	 */
	protected String password;
  
  /**
	 * La date de naissance du joueur.
	 */
	protected Date birthDate;
	
	/**
	 * Historique des parties jouées par le joueur depuis qu'il s'est inscrit
	 * 
	 * @see PartieJeu
	 */
	protected LinkedList<PartieJeu> playerGames;
	
	public Joueur() {
		this.id = -1;		//Pour ne pas accéder à un joueur si on initialise
							//pas cette variable d'instance
		
		this.firstName = "";//On utilise ce paramètre pour vérifier que le
							//joueur n'est pas initialisé
		this.playerGames = null;
	}
	
	/**
	 * Récupère le numéro séquentiel du joueur
	 * @return numéro séquentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Initialise le numéro séquentiel du joueur à un entier
	 * <p>
	 * 	Note : l'unicité de l'id dans la liste des joueurs avant d'utiliser
	 *  cette méthode 
	 * </p>
	 */
	public void setId() {
		this.id = this.hashCode();
	}
	
	/**
	 * <p>
	 * Utilise la fonction de Objects pour créer un Numéro séquentiel et
	 * utilise la fonction Math.Abs pour s'assurer que id >= 0 vu qu'il est
	 * utilisé pour accéder à  la liste des joueurs, voir les méthodes connexion
	 * et inscription
	 * </p>
	 * 
	 * @return un numéro séquentielle qui identifie le joueur
	 * 
	 * @see com.usthb.MainApp#connection()
	 * @see com.usthb.MainApp#inscription()
	 */
	public int hashCode() {
		return Math.abs(Objects.hash(this.username));
	}

	/**
	 * Récupère le prénom du joueur
	 * @return Le prénom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	
	/**
	 * Récupère le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * <p>
	 * Initialise le nom d'utilisateur au nom donné, ce username doit être
	 * unique et son unicité est verifiée à travers l'unicité de l'id généré, voir
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
	 * Récupère le mot de passe du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale de la liste des parties jouées.
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