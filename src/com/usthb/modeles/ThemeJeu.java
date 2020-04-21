/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;
import java.util.Objects;

import com.usthb.MainApp;

/**
 * <b>Représente un thème du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.0
 */
public class ThemeJeu {
	
	private static int questionsNumber = 0;
	
	/**
	 * <p>
	 * 	Utilisé pour calculer le score d'une partie, en effet le score de
	 * 	chaque question, selon son niveau, sera multiplié par ce nombre pour
	 * 	être ajouté au score totale qui est le score de la partie. 
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see PartieJeu#score
	 */
	protected int coefficent;
	
	/**
	 * Le texte qui représente le thème.
	 */
	protected String lable;
	
	/**
	 * Une liste de question du thème.
	 * 
	 * @see Question
	 */
	protected LinkedList <Question> questions = new LinkedList<Question>();		//Liste des questions.
	
	/**
	 * Le type du thème.
	 * <p>
	 * 	Pour plus d'unfirmation sur les valeurs possible, voir documentation de
	 * 	l'énumeration ThemeType
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
			Levels questionLvl;
			String questionLable;
			String questionAnswer;
			
			System.out.println("lvl 1, 2, 3, 4, 5");
			questionLvl = Levels.getLvl(MainApp.console.nextInt());
			MainApp.console.nextLine();
			
			System.out.println("lable");
			questionLable = new String(MainApp.console.nextLine());
			
			System.out.println("answer");
			questionAnswer = new String(MainApp.console.nextLine());
			
			ThemeJeu.questionsNumber++;
			this.questions.add(new Question(this.generateQuestionID(), questionLvl, questionLable, questionAnswer));
			
			System.out.println("More ? y/n");
			c = MainApp.console.nextLine().charAt(0);
		} while (c == 'y');
	}
	
	/**
	 * 
	 * @return
	 * 
	 * @since 1.1.0
	 */
	public String generateQuestionID() {
		return this.type.getAbreviation()
				+ this.hashCode() + ""
				+ ThemeJeu.questionsNumber;
	}
	
	/**
	 * @since 1.1.0
	 */
	public int hashCode() {
		return Math.abs(Objects.hash(this.lable));
	}
	
	/**
	 * @since 1.1.0
	 */
	public String toString() {
		return "" + type + ": "
				+ lable + ", coefficient "
				+ coefficent + " question:"
				+ questions;
	}
}
