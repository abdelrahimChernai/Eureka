/**
 * 
 */
package com.usthb.modeles;

/**
 * <b>Représente une Parte du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class PartieJeu {
	protected int number;
	
	/**
	 * Le score collecté par le joueur durant la partie.
	 */
	protected int score;
	//TODO add question number or question id when clarified.
	
	protected String Theme;											//Thème sélectionné.
	
	/**
	 * Réponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentCnswer;
}
 