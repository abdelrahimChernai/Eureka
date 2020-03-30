/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;

/**
 * <b>Joueur est la class représentant un joueur.</b>
 * <p>
 * 	Un joueur a :
 * 	<ul>
 * 		<li>Un numéro séquentielle unique.</li>
 * 		<li>Un niveau allant de 1 à 5 et représentant le niveau courant du joueur.</li>
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
	 * Numéro séquentiel automatique unique caractérisant le joueur.
	 * Aussi utilisé comme clé pour accéder au information du joueur dans la list des joueurs.
	 * <p>
	 * 	Pour plus d'information sur la list des joueur voir la documentation de la class MainApp
	 * 	voir la documentation de la class MainApp
	 * </p>
	 * 
	 * @see com.usthb.MainApp
	 */
	protected int id;
	
	/**
	 * Le niveau atteint par le joueurs lors de ça dernière partie.
	 * Ce niveau peut être entre 1 et 5 incluent chaque niveau passé donne un nombre de point.
	 */
	protected int currentLvl;			//Dernier niveau atteint
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Prénom du joueur.
	protected String username;			//Nom d'utilisateur.
	protected String password;			//Mot de passe.
	protected Date birthDate;			//Date de naissance.
	
	public Joueur() {
		
	}
	
}