/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;

/**
 * <b>Représente une theme du jeu et contient toutes se données</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class ThemeJeu {
	
	/**
	 * <p>
	 * 	Utilisé pour calculer le score d'une partie, en effet le score de
	 * 	chaque question, selon son niveau, sera multiplié par ce nombre pour
	 * 	être ajouté au score totale qui est le score de la partie. 
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see PartieJeu#score
	 */
	protected int coefficent;
	
	/**
	 * Le texte qui représente le theme.
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
