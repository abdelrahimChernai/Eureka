/**
 * 
 */
package com.usthb.modeles;

/**
 * <b>Repr�sente une question ainsi que toutes les donn�es associ�e</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class Question {
	protected int id;								//Num�ro s�quentiel automatique.
	//TODO add question number when clarified.
	protected int lvl;								//Niveau entre 1 et 5 les deux inclues.
	
	/**
	 * Le texte de la question seras affich� sous l'image contenant la question.
	 * 
	 * @see Question#imagePath
	 */
	protected String lable;
	
	/**
	 * La r�ponse que le Joueur doit trouver 
	 */
	protected String answer;
	
	/**
	 * <p>
	 * 	Un chemin vers une image contenant la question, dans le cas ou celle-ci
	 * 	le libell� pourra la remplac�.
	 * </p>
	 */
	protected String imagePath;						//Lien vers l'image associ�e.
}
