package com.usthb.modeles;

/**
 * <b>Représente une question ainsi que toutes les données associée</b>
 * 
 * @author Abdelrahim Chernai
 * @version 2.0
 */
public class Question {
	protected int id;								//Numéro séquentiel automatique.
	//TODO add question number when clarified.

	/**
	 * Le niveaux de la question, ce dernier est associé a un nombre de points
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels lvl;
  
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
	 * 	ne s'affiche pas le libellé pourra la remplacé.
	 * </p>
	 */
	protected String imagePath;						//Lien vers l'image associée.

	/**
	 * donne le nombre de points associé a une bonne repose à la question
	 * @return les point associé au niveau voir documentation de Levels pour
	 *  les valeurs exactes
	 *  
	 *  @see Levels
	 *  @since 2.0
	 */
	public int getNumberPoints() {
		return lvl.lvlPoints;
	}
}
