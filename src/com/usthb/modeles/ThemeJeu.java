/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;

/**
 * <b>Repr�sente une theme du jeu et contient toutes se donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class ThemeJeu {
	
	/**
	 * <p>
	 * 	Utilis� pour calculer le score d'une partie, en effet le score de
	 * 	chaque question, selon son niveau, sera multipli� par ce nombre pour
	 * 	�tre ajout� au score totale qui est le score de la partie. 
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see PartieJeu#score
	 */
	protected int coefficent;
	
	/**
	 * Le texte qui repr�sente le theme.
	 */
	protected String lable;
	
	/**
	 * Une liste des question du theme.
	 * 
	 * @see Question
	 */
	protected LinkedList <Question> questions;		//Liste des questions.
	//TODO create an enumeration representing the type instance variable
	
}
