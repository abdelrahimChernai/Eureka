package com.usthb.modeles;

import java.io.Serializable;
import java.util.LinkedList;

import com.usthb.dessin.Potence;


/**
 * <b>Représente une Parte du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.0
 */
public class PartieJeu implements Serializable {
	private static int gamesNumber = 1;
	
	private final int number = PartieJeu.gamesNumber;
	
	/**
	 * <p>
	 * 	Le score collecté par le joueur durant la partie, est calculé en
	 * 	utilisant le score du niveau de chaque question multiplié par le
	 * 	coefficient de son thème.
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see ThemeJeu#coefficent
	 */
	private int score = 0;
	
	private boolean win;

	/**
	 * <p>
	 * 	L'identificateure de la question actuelle de la partie, sera utilisé
	 * 	pour récupérer la réponse à la question à partir de la listes des
	 * 	questions du thème afin de verifier si la réponse en cours est correcte
	 * 	dans la méthode PartieJeu.checkChar()
	 * </p> 
	 * 
	 * @see ThemeJeu#questions
	 * @see PartieJeu#theme
	 * @see PartieJeu#checkChar(char)
	 */
	private String questionId;
	
	/**
	 * Thème de la partie en cours
	 * 
	 * @see ThemeJeu
	 */
	private ThemeJeu theme;
  
	/**
	 * <p>
	 * 	Réponse actuelle saisie par le joueur, mis à jours à chaque fois que le
	 * 	joueur entre une lettre
	 * </p>
	 */
	private StringBuffer currentAnswer;
	
	private LinkedList<Question> questions;
	
	/**
	 * <p>
	 * 	Le pendu de cette partie, garde ces données et s'occupes de le dessiner
	 *	Ses données dont altéré dans la méthode PartieJeu.checkCher selon si la
	 *	réponse du joueur est correcte ou fausse.
	 * </p>
	 * 
	 * @see com.usthb.dessin.Potence
	 * 
	 * @see PartieJeu#checkChar(char)
	 */
	private static Potence hangman = new Potence();
	
	public PartieJeu(ThemeJeu theme, LinkedList<? extends Question> questions) {
		gamesNumber++;
		this.win = false;
		this.theme = theme;
		this.questions = (LinkedList<Question>) questions;
	}
	
	public int getScore() {
		return score;
	}

	public boolean isWin() {
		return win;
	}

	public ThemeJeu getTheme() {
		return theme;
	}

	public String getCurrentAnswer() {
		return currentAnswer.toString();
	}

	public static Potence getHangman() {
		return hangman;
	}
		
	public Question getQuestion() {
		int i = 0;
		
		while (
				i < questions.size() 
				&& ! questions.get(i).getId().equals(this.questionId)
			) {
			
			i++;
		}
		
		return questions.get(i);
	}
	
	public int getCurrentLevel() {
		return questionId.charAt(questionId.length() - 1) - 48;
	}
	
	public int getAttemptsLeft() {
		return 0 + hangman.getState();
	}
	
	/**
	 * <p>
	 * 	Génère l'id de la question suivante et initialise la réponse courante a 
	 * 	des '*'
	 * </p> 
	 */
	private void setNextQuestionId() {
		questionId =
				theme.generateQuestionID()
				+ (Integer.valueOf(
						questionId.substring(
								questionId.length() - 1)
						)
						+ 1);
	}
	
	private void setupCurrnetAnswer(String answer) {
		currentAnswer = new StringBuffer(answer.length());
		
		for (int i = 0; i < this.currentAnswer.capacity(); i++) {
			if (answer.charAt(i) != ' ') {
				currentAnswer.insert(i, '*');
			} else {
				currentAnswer.insert(i, ' ');
			}
		}
	}
	
	public void startGame() {
		hangman.clearState();
		this.questionId = theme.generateQuestionID() + 1;		
		setupCurrnetAnswer(getQuestion().getAnswer());
	}
	
	private void nextLevel() {
		hangman.clearState();
		score += theme.coefficent * this.getQuestion().getNumberPoints();
		setNextQuestionId();
		setupCurrnetAnswer(getQuestion().getAnswer());
		
	}
	
	/**
	 * <b>
	 * 	Cette fonction vérifie si le caractère entré par le joueur est dans la
	 *  réponse de la question  puis effectue des traitements selon le résultat
	 * </b>
	 * <p>
	 * 	Les traitement fait sont les suivant :
	 * 	<ul>
	 * 		<li>
	 * 			si le caractère est un des caractères de la question :
	 * 			<ol>
	 * 				<li>
	 * 					Remplace les '*' dans la réponse en coure aux positions
	 * 					correspondantes au caractère donné.
	 * 				</li>
	 *				<li>
	 *					Vérifie si la réponse en cours et égale à la réponse de
	 *					la question si c'est le cas on considère la réponse
	 *					comme trouvée, voir la documentation de la classe
	 *					Potence pour plus de détails, sinon ne fait rien.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caractère n'est pas un des caractères de la réponse
	 * 			l'état de la potence est incrémenté puis la potence est 
	 * 			re-dessinée, voir la documentation de la classe Potence pour
	 * 			plus de détails
	 * 		</li>
	 * </ul>
	 * </p>
	 * @param inputChar le caractère entrée par le joueur
	 * 
	 * @see Question
	 * @see PartieJeu#currentAnswer
	 * @see PartieJeu#theme
	 * @see PartieJeu#questionId
	 * @see com#usthb#dessin#Potence
	 */
	public void checkChar(char inputChar) {
		String answer = getQuestion().getAnswer();
		
		if (
				answer.indexOf(inputChar) != -1
				&& currentAnswer.indexOf(Character.toString(inputChar)) == -1
			) {//si le caractère est dans answer et n'est pas dans la réponse
			
			for (int i = 0; i < answer.length(); i++) {

				if (answer.charAt(i) == inputChar) {
					currentAnswer.deleteCharAt(i);
					currentAnswer.insert(i, inputChar);
				}
			}
			
			if (answer.equals(currentAnswer.toString())) {//convertie
				//currentAnswer en String puis compare avec answer
				
				if (Integer.valueOf(questionId.substring(questionId.length() - 1)) == 5) {
					this.win = true; 
					score += theme.coefficent * this.getQuestion().getNumberPoints();
				} else {
					hangman.setFoundAnswer();
					nextLevel();
 				}
				/*
				 * TODO open a pop-up window to tell the player that the answer
				 * is correct and give his the next question if any is
				 * available else tell him that he wont this game 
				*/
			}
		} else {
			hangman.incrementState();
			//TODO draw the next state of the Hangman (maybe animated)
		}
	}
	
	public String toString() {
		return "Game number: " + number + " question id: "
				+ questionId + "score = "
				+ score + " currnet answe: "
				+ currentAnswer;
	}
}
 