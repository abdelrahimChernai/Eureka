package com.usthb.modeles;

/**
 * <b>Repr�sente une question ainsi que toutes les donn�es associ�es</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 */
public class Question {
	protected int id;								//Num�ro s�quentiel automatique.
	//TODO add question number when clarified.

	/**
	 * Le niveau de la question, ce dernier est associ� � un nombre de points
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels lvl;
  
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
	 * 	ne s'affiche pas le libell� pourra la remplacer.
	 * </p>
	 */
	protected String imagePath;						//Lien vers l'image associ�e.

	/**
	 * donne le nombre de points associ� a une bonne r�ponse � la question
	 * @return le nombre de point associ� au niveau, voir documentation de Levels pour
	 *  les valeurs exactes
	 *  
	 *  @see Levels
	 *  @since 2.0
	 */
	public int getNumberPoints() {
		return lvl.lvlPoints;
	}
}
