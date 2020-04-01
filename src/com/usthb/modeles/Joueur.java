package com.usthb.modeles;

import java.util.Date;

/**
 * <b>Joueur est la class représentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 * 
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
	 * 	Le niveau atteint par le joueurs lors de ça dernière partie peut être
	 * 	entre 1 et 5 incluent, chaque niveau passé donne un certain nombre de
	 *  point et permet au joueur de reprendre ça partie au même niveau.
	 * </p>
	 */
	protected int currentLvl;			//Dernier niveau atteint
	
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
	 * 	Le nom d'utilisateur à partir du quel on génère un id unique cette
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
	
	public Joueur() {
		
	}
	
}