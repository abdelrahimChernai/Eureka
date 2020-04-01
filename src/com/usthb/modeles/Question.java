/**
 * 
 */
package com.usthb.modeles;

/**
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
	protected String lable;							//Libellé.
	protected String answer;						//Réponse.
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
