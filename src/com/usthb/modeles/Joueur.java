/**
 * 
 */
package com.usthb.modeles;

import java.util.Date;

/**
 * @author Abdelrahim Chernai
 * 
 */
public class Joueur {
	protected int id;					//Numéro séquentiel automatique.
	protected int currentLvl;			//Dernier niveau atteint
	protected String lastName;			//Nom du joueur.
	protected String firstName;			//Prénom du joueur.
	protected String username;			//Nom d'utilisateur.
	protected String password;			//Mot de passe.
	protected Date birthDate;			//Date de naissance.
	
	public Joueur() {
		
	}
	
}