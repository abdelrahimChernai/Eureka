package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * <b>Joueur est la classe repr�sentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 * @see ParieJeu
 */
public class Joueur {
  
  /**
	 * <p>
	 *  Num�ro s�quentiel automatique unique caract�risant le joueur et utilis�
	 *  comme cl� pour acc�der aux informations du joueur dans la liste des 
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
	 *  Le niveau le plus r�cent du joueur est celui atteint lors de derni�re partie jou�e,
   *  chaque niveau d�bloqu� offre un certain nombre de points et permet au joueur
   *  de reprendre la partie au m�me niveau.
	 * </p>
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels currentLvl;
  
	/**
	 * <p>
	 * 	Repr�sente le Nom du joueur, est demand� lors de son inscription
	 * </p>
	 */
	protected String lastName;
  
	/**
	 * <p>
	 * 	Repr�sente le Pr�nom du joueur, est demand� lors de son inscription
	 * </p>
	 */
	protected String firstName;
  
	/**
	 * <p>
	 * 	Le nom d'utilisateur � partir duquel on g�n�re un id unique, cette
	 * 	unicit� est assur� car lors de la r�cup�ration de ce nom d'utilisateur
	 *  on g�n�re un id et on v�rifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur d'en saisir un autre, est aussi utilis� lors de la
	 *  connection de joueur.
	 * </p>
	 */
	protected String username;
  
  /**
	 * <p>
	 * 	On l'utilise lors de la connexion du joueur pour s'assurer de son
	 * 	identit�.
	 * </p>
	 */
	protected String password;
  
  /**
	 * La date de naissance du joueur.
	 */
	protected Date birthDate;
	
	/**
	 * Historique des parties jou�es par le joueur depuis qu'il s'est inscrit
	 * 
	 * @see PartieJeu
	 */
	protected LinkedList<PartieJeu> playerGames;
	
	public Joueur() {
		this.id = -1;		//Pour ne pas acc�der � un joueur si on initialise
							//pas cette variable d'instance
		
		this.firstName = "";//On utilise ce param�tre pour v�rifier que le
							//joueur n'est pas initialis�
		this.playerGames = null;
	}
	
	/**
	 * R�cup�re le num�ro s�quentiel du joueur
	 * @return num�ro s�quentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Initialise le num�ro s�quentiel du joueur � un entier
	 * <p>
	 * 	Note : l'unicit� de l'id dans la liste des joueurs avant d'utiliser
	 *  cette m�thode 
	 * </p>
	 */
	public void setId() {
		this.id = this.hashCode();
	}
	
	/**
	 * <p>
	 * Utilise la fonction de Objects pour cr�er un Num�ro s�quentiel et
	 * utilise la fonction Math.Abs pour s'assurer que id >= 0 vu qu'il est
	 * utilis� pour acc�der � la liste des joueurs, voir les m�thodes connexion
	 * et inscription
	 * </p>
	 * 
	 * @return un num�ro s�quentielle qui identifie le joueur
	 * 
	 * @see com.usthb.MainApp#connection()
	 * @see com.usthb.MainApp#inscription()
	 */
	public int hashCode() {
		return Math.abs(Objects.hash(this.username));
	}

	/**
	 * R�cup�re le pr�nom du joueur
	 * @return Le pr�nom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	
	/**
	 * R�cup�re le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * <p>
	 * Initialise le nom d'utilisateur au nom donn�, ce username doit �tre
	 * unique et son unicit� est verifi�e � travers l'unicit� de l'id g�n�r�, voir
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
	 * R�cup�re le mot de passe du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale de la liste des parties jou�es.
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