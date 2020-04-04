package com.usthb.modeles;

/**
 * <b>Repr�sente une question ainsi que toutes les donn�es associ�es</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 2.0
 */
public class Question {
	/**
	 * <p>
	 * 	Identifie les question de mani�re unique, compos� en concat�nant une
	 * 	suit de 3 caract�re repr�sentant le type de th�me + un num�ro g�n�r� �
	 * 	partir du libell� du th�me et un indice repr�sentant le nombre de cette
	 * 	question dans son th�me.
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
	protected String imagePath;
	
	public Question(String id, Levels lvl, String lable, String answer) {
		this.id = id;
		this.lvl = lvl;
		this.lable = lable;
		this.answer = answer;
	}

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
	
	public String toString() {
		return "" + id + ": "
				+ lable + " level "
				+ lvl.getLvlNumber();
	}
}
