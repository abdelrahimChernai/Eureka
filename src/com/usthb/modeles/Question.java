package com.usthb.modeles;

import java.io.Serializable;

/**
 * <b>Représente une question ainsi que toutes les données associées</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.1.0
 */
public class Question implements Serializable {
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
	private String id;
	
	/**
	 * Le niveau de la question, ce dernier est associé à un nombre de points
	 * 
	 * @see Levels
	 * @since 2.0
	 */
	private Levels lvl;
  
	/**
	 * Le texte de la question seras affiché sous l'image contenant la question.
	 * 
	 * @see Question#imagePath
	 */
	private String lable;

	/**
	 * La réponse que le Joueur doit trouver 
	 */
	private String answer;

	/**
	 * <p>
	 * 	Un chemin vers une image contenant la question, dans le cas ou celle-ci
	 * 	ne s'affiche pas le libellé pourra la remplacer.
	 * </p>
	 */
	private String imagePath;
	
	public Question(String id, Levels lvl, String lable, String answer) {
		this.id = id;
		this.lvl = lvl;
		this.lable = lable;
		this.answer = answer;
	}
	
	public String getId() {
		return id;
	}

	public String getLable() {
		return lable;
	}

	public String getAnswer() {
		return answer;
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
	
	/**
	 * @since 2.1.0
	 */
	public String toString() {
		return "" + id + ": "
				+ lable + " level "
				+ lvl.getLvlNumber();
	}
}
