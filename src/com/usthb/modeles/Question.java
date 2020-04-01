/**
 * 
 */
package com.usthb.modeles;

/**
 * <b>Représente une question ainsi que toutes les données associée</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class Question {
	protected int id;								//Numéro séquentiel automatique.
	//TODO add question number when clarified.
	protected int lvl;								//Niveau entre 1 et 5 les deux inclues.
	
	/**
	 * Le texte de la question seras affiché sous l'image contenant la question.
	 * 
	 * @see Question#imagePath
	 */
	protected String lable;
	
	/**
	 * La réponse que le Joueur doit trouver 
	 */
	protected String answer;
	
	/**
	 * <p>
	 * 	Un chemin vers une image contenant la question, dans le cas ou celle-ci
	 * 	le libellé pourra la remplacé.
	 * </p>
	 */
	protected String imagePath;						//Lien vers l'image associée.
}
