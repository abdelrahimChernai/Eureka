package com.usthb.modeles;

import java.util.Date;

/**
 * <b>Joueur est la class représentant un joueur.</b>
 * <p>
 * 	Un joueur a :
 * 	<ul>
 * 		<li>Un numéro séquentielle unique.</li>
 * 		<li>
 * 			Un niveau allant de 1 à 5 et représentant le niveau courant du
 * 			joueur.
 * 		</li>
 * 		<li>Un nom.</li>
 * 		<li>Un prénom.</li>
 * 		<li>Un pseudo unique avec le quelle le joueur s'identifie.</li>
 * 		<li>Un mot de passe.</li>
 * 		<li>Une date de naissance.</li>
 * 		<li>Une liste des parties jouées.</li>
 * </ul>
 * 
 * @see ParieJeu
 * 
 * </p>
 * @author Abdelrahim Chernai
 * @version 1.0
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