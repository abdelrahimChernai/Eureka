/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;

/**
 * @author Abdelrahim Chernai
 * @version 2.0
 */
public class Joueur {
	protected int id;					//Numéro séquentiel automatique.
	
	/**
	 * Le niveau le plus ressent du joueur atteint lors de dernière partie joué
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
	
	public Joueur() {
		
	}
	
}