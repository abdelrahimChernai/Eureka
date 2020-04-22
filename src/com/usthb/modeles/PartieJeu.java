package com.usthb.modeles;

import java.io.Serializable;

import com.usthb.dessin.Potence;


/**
 * <b>Représente une Parte du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.0
 */
public class PartieJeu implements Serializable {
	private int number;
	
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
	private int score;

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
	private Potence hangman = new Potence();
	
	public PartieJeu(int number, ThemeJeu theme) {
		
		this.number = number;
		this.score = 0;
		this.theme = theme;
		this.questionId = theme.generateQuestionID() + 1;		
		setupCurrnetAnswer(getQuestion().answer);
	}
	
	public int getScore() {
		return score;
	}

	public Potence getHangman() {
		return hangman;
	}
		
	private Question getQuestion() {
		int i = 0;
		
		while (
				i < theme.questions.size() 
				&& ! theme.questions.get(i).id.equals(this.questionId)
			) {
			
			i++;
		}
		
		return theme.questions.get(i);
	}
	
	
	/**
	 * <p>
	 * 	Génère l'id de la question suivante et initialise la réponse courante a 
	 * 	des '*'
	 * </p> 
	 */
	private void setNextQuestionId() {
		this.questionId =
				this.theme.generateQuestionID()
				+ (Integer.valueOf(
						this.questionId.substring(
								this.questionId.length() - 1)
						)
						+ 1);
	}
	
	private void setupCurrnetAnswer(String answer) {
		this.currentAnswer = new StringBuffer(answer.length());
		
		for (int i = 0; i < this.currentAnswer.capacity(); i++) {
			if (answer.charAt(i) != ' ') {
				this.currentAnswer.insert(i, '*');
			} else {
				this.currentAnswer.insert(i, ' ');
			}
		}
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
		String answer = getQuestion().answer;
		
		if (
				answer.indexOf(inputChar) != -1
				&& currentAnswer.indexOf(Character.toString(inputChar)) == -1
			) {//si le caractère est dans answer
			
			for (int i = 0; i < answer.length(); i++) {

				if (answer.charAt(i) == inputChar) {
					this.currentAnswer.deleteCharAt(i);
					this.currentAnswer.insert(i, inputChar);
				}
			}
			
			System.out.println(this.currentAnswer);
			
			if (answer.equals(this.currentAnswer.toString())) {//convertie
				//currentAnswer en String puis compare avec answer
				
				if (Integer.valueOf(this.questionId.substring(questionId.length() - 1)) == 5) {
//					hangman.setFoundAnswerTrue();
					System.out.println("You Won!");
				} else {
					setNextQuestionId();
					setupCurrnetAnswer(getQuestion().answer);
					System.out.println("Level " + this.questionId.charAt(questionId.length() - 1));
 				}
				/*
				 * TODO open a pop-up window to tell the player that the answer
				 * is correct and give his the next question if any is
				 * available else tell him that he wont this game 
				*/
			}
		} else {
			hangman.incrementState();
			System.out.println("nah..." + hangman.getState());
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
 