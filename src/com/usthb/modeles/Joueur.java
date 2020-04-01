package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * <b>Joueur est la class repr�sentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @version 2.0
 * @see ParieJeu
 */
public class Joueur {
  
  /**
	 * <p>
	 * 	Num�ro s�quentiel automatique unique caract�risant le joueur et utilis�
	 *  comme cl� pour acc�der au information du joueur dans la list des 
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
	 *  Le niveau le plus ressent du joueur atteint lors de derni�re partie jou�
   *  chaque niveau pass� donne un certain nombre de point et permet au joueur
   *  de reprendre ça partie au m�me niveau.
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
	 * 	Le nom d'utilisateur à partir du quel on g�n�re un id unique cette
	 * 	unicit� est assur� car lors de la r�cup�ration de ce nom d'utilisateur
	 * 	une g�n�re un id et on v�rifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur de donner un autre, est aussi utilis� lors de la
	 *  connection de joueur.
	 * </p>
	 */
	protected String username;
  
  /**
	 * <p>
	 * 	On l'utilise lors de la connection du joueur pour s'assurer de son
	 * 	identit�.
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
	 * utilis� pour acc�der à la liste des joueurs voir les m�thodes connection
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