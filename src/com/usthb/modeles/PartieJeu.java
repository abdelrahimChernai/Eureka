/**
 * 
 */
package com.usthb.modeles;

/**
 * <b>Repr�sente une Parte du jeu et contient toutes ses donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class PartieJeu {
	protected int number;
	
	/**
	 * Le score collect� par le joueur durant la partie.
	 */
	protected int score;
	//TODO add question number or question id when clarified.
	
	protected String Theme;											//Th�me s�lectionn�.
	
	/**
	 * R�ponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentCnswer;
}
 