/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;
import java.util.Objects;

import com.usthb.MainApp;

/**
 * <b>Repr�sente un th�me du jeu et contient toutes ses donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 */
public class ThemeJeu {
	
	private static int questionsNumber = 0;
	
	/**
	 * <p>
	 * 	Utilis� pour calculer le score d'une partie, en effet le score de
	 * 	chaque question, selon son niveau, sera multipli� par ce nombre pour
	 * 	�tre ajout� au score totale qui est le score de la partie. 
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see PartieJeu#score
	 */
	protected int coefficent;
	
	/**
	 * Le texte qui repr�sente le th�me.
	 */
	protected String lable;
	
	/**
	 * Une liste de question du th�me.
	 * 
	 * @see Question
	 */
	protected LinkedList <Question> questions = new LinkedList<Question>();		//Liste des questions.
	
	/**
	 * Le type du th�me.
	 * <p>
	 * 	Pour plus d'unfirmation sur les valeurs possible, voir documentation de
	 * 	l'�numeration ThemeType
	 * </p>
	 * 
	 * @see ThemeType
	 */
	protected ThemeType type;
	
	public ThemeJeu(int coefficent, String lable, ThemeType type) {
		char c = 'y';
		
		this.coefficent = coefficent;
		this.lable = lable;
		this.type = type;

		do {
			String questionLable;
			String questionAnswer;
			
			System.out.println("lable");
			questionLable = new String(MainApp.consol.nextLine());
			
			System.out.println("answe");
			questionAnswer = new String(MainApp.consol.nextLine());
			
			this.questionsNumber++;
			this.questions.add(new Question("His" + this.hashCode() + "" + this.questionsNumber, Levels.LEVEL_3, questionLable, questionAnswer));
			
			System.out.println("More ? y/n");
			c = MainApp.consol.nextLine().charAt(0);
		} while (c == 'y');
	}
	
	public int hashCode() {
		return Math.abs(Objects.hash(this.lable));
	}
	
	public String toString() {
		return "" + type + ": "
				+ lable + ", coefficient "
				+ coefficent + " question:"
				+ questions;
	}
}
