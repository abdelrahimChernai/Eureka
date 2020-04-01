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
	 * <p>
	 * 	Le score collect� par le joueur durant la partie, est calculer en
	 * 	utilisant le score du niveau de chaque question multipli� par le
	 * 	coefficient de son th�me.
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see ThemeJeu#coefficent
	 */
	protected int score;
	//TODO add question number or question id when clarified.
	
	protected String Theme;											//Th�me s�lectionn�.
	
	/**
	 * R�ponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentCnswer;
}
 