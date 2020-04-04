package com.usthb.modeles;

/**
 * <b>Représente une question ainsi que toutes les données associées</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 */
public class Question {
	/**
	 * <p>
	 * 	Identifie les question de manière unique, composé en concaténant une
	 * 	suit de 3 caractère représentant le type de thème + un numéro généré à
	 * 	partir du libellé du thème et un indice représentant le nombre de cette
	 * 	question dans son thème.
	 * </p>
	 * 
	 * @see ThemeType
	 * @see Theme
	 * 
	 * @see ThemeJeu#lable
	 * @since 2.0
	 */
	protected String id;
	
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
	protected String imagePath;
	
	public Question(String id, Levels lvl, String lable, String answer) {
		this.id = id;
		this.lvl = lvl;
		this.lable = lable;
		this.answer = answer;
	}

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
	
	public String toString() {
		return "" + id + ": "
				+ lable + " level "
				+ lvl.getLvlNumber();
	}
}
