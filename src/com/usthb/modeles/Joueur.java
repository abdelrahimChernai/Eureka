/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;

/**
 * <b>Joueur est la class repr�sentant un joueur.</b>
 * <p>
 * 	Un joueur a :
 * 	<ul>
 * 		<li>Un num�ro s�quentielle unique.</li>
 * 		<li>Un niveau allant de 1 � 5 et repr�sentant le niveau courant du joueur.</li>
 * 		<li>Un nom.</li>
 * 		<li>Un pr�nom.</li>
 * 		<li>Un pseudo unique avec le quelle le joueur s'identifie.</li>
 * 		<li>Un mot de passe.</li>
 * 		<li>Une date de naissance.</li>
 * 		<li>Une liste des parties jou�es.</li>
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
	 * Num�ro s�quentiel automatique unique caract�risant le joueur.
	 * Aussi utilis� comme cl� pour acc�der au information du joueur dans la list des joueurs.
	 * <p>
	 * 	Pour plus d'information sur la list des joueur voir la documentation de la class MainApp
	 * 	voir la documentation de la class MainApp
	 * </p>
	 * 
	 * @see com.usthb.MainApp
	 */
	protected int id;
	
	/**
	 * Le niveau atteint par le joueurs lors de �a derni�re partie.
	 * Ce niveau peut �tre entre 1 et 5 incluent chaque niveau pass� donne un nombre de point.
	 */
	protected int currentLvl;			//Dernier niveau atteint
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Pr�nom du joueur.
	protected String username;			//Nom d'utilisateur.
	protected String password;			//Mot de passe.
	protected Date birthDate;			//Date de naissance.
	
	public Joueur() {
		
	}
	
}