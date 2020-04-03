package com.usthb.modeles;

/**
 * <b>Représente une question ainsi que toutes les données associées</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 */
public class Question {
	protected int id;								//Numéro séquentiel automatique.
	//TODO add question number when clarified.

	/**
	 * Le niveau de la question, ce dernier est associé à un nombre de points
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
	 * 	ne s'affiche pas le libellé pourra la remplacer.
	 * </p>
	 */
	protected String imagePath;						//Lien vers l'image associée.

	/**
	 * donne le nombre de points associé a une bonne réponse à la question
	 * @return le nombre de point associé au niveau, voir documentation de Levels pour
	 *  les valeurs exactes
	 *  
	 *  @see Levels
	 *  @since 2.0
	 */
	public int getNumberPoints() {
		return lvl.lvlPoints;
	}
}
