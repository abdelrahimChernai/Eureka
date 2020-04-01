package com.usthb.modeles;

import java.util.Date;

/**
 * <b>Joueur est la class repr�sentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 * 
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
	 * 	Le niveau atteint par le joueurs lors de �a derni�re partie peut �tre
	 * 	entre 1 et 5 incluent, chaque niveau pass� donne un certain nombre de
	 *  point et permet au joueur de reprendre �a partie au m�me niveau.
	 * </p>
	 */
	protected int currentLvl;			//Dernier niveau atteint
	
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
	 * 	Le nom d'utilisateur � partir du quel on g�n�re un id unique cette
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
	
	public Joueur() {
		
	}
	
}