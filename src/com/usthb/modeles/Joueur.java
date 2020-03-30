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
	protected int id;					//Num�ro s�quentiel automatique.
	
	/**
	 * Le niveau le plus ressent du joueur atteint lors de derni�re partie jou�
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels currentLvl;
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Pr�nom du joueur.
	protected String username;			//Nom d'utilisateur.
	protected String password;			//Mot de passe.
	protected Date birthDate;			//Date de naissance.
	
	public Joueur() {
		
	}
	
}