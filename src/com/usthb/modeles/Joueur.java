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
	private int id;					//Numéro séquentiel.
	private int currentLvl;			//Deriner niveau atteint
	private String lastName;		//Nom du joueur.
	private String firstName;		//Prenom du joueur.
	private String username;		//Nom d'utilisateur.
	private String password;		//Mot de passe.
	private Date birthDate;			//Date de naissence.
	
	public Joueur() {
		
	}
	
	
	public int getId() {
		return this.id;
	}
	
	// TODO create a id generator for the players
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCurrentLvl() {
		return this.currentLvl;
	}
	
	public void setCurrentLvl(int currentLvl) {
		this.currentLvl = currentLvl;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthDate () {
		return this.birthDate;
	}
	
	public void setBirthDate (Date birthDate) {
		this.birthDate = birthDate; 
	}
}