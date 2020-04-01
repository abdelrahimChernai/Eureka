/**
 * 
 */
package com.usthb.modeles;

/**
 * @author Abdelrahim Chernai
 * @version 2.0
 */
public class Question {
	protected int id;								//Num�ro s�quentiel automatique.
	//TODO add question number when clarified.
	
	/**
	 * Le niveaux de la question, ce dernier est associ� a un nombre de points
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	protected Levels lvl;							
	protected String lable;							//Libell�.
	protected String answer;						//R�ponse.
	protected String imagePath;						//Lien vers l'image associ�e.

	/**
	 * donne le nombre de points associ� a une bonne repose � la question
	 * @return les point associ� au niveau voir documentation de Levels pour
	 *  les valeurs exactes
	 *  
	 *  @see Levels
	 *  @since 2.0
	 */
	public int getNumberPoints() {
		return lvl.lvlPoints;
	}
}
