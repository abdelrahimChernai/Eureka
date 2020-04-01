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
	 * <p>
	 * 	Le score collecté par le joueur durant la partie, est calculer en
	 * 	utilisant le score du niveau de chaque question multiplié par le
	 * 	coefficient de son thème.
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see ThemeJeu#coefficent
	 */
	protected int score;
	//TODO add question number or question id when clarified.
	
	protected String Theme;											//Thème sélectionné.
	
	/**
	 * Réponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentCnswer;
}
 