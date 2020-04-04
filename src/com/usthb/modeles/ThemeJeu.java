/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;

/**
 * <b>Représente un thème du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
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
	 * Le texte qui représente le thème.
	 */
	protected String lable;
	
	/**
	 * Une liste de question du thème.
	 * 
	 * @see Question
	 */
	protected LinkedList <Question> questions;		//Liste des questions.
	
	/**
	 * Le type du thème.
	 * <p>
	 * 	Pour plus d'unfirmation sur les valeurs possible, voir documentation de
	 * 	l'énumeration ThemeType
	 * </p>
	 * 
	 * @see ThemeType
	 */
	protected ThemeType type;
	
	public ThemeJeu(int coefficent, String lable, ThemeType type) {
		this.coefficent = coefficent;
		this.lable = lable;
		this.type = type;
	}
	
	public String toString() {
		return "" + type + ": "
				+ lable + ", coefficient "
				+ coefficent;
	}
}
