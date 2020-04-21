package com.usthb.modeles;

import com.usthb.dessin.Potence;

/**
 * <b>Repr�sente une Parte du jeu et contient toutes ses donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.0
 */
public class PartieJeu {
	private int number;
	
	/**
	 * <p>
	 * 	Le score collect� par le joueur durant la partie, est calcul� en
	 * 	utilisant le score du niveau de chaque question multipli� par le
	 * 	coefficient de son th�me.
	 * </p>
	 * 
	 * @see Question#lvl
	 * @see ThemeJeu#coefficent
	 */
	private int score;

	/**
	 * <p>
	 * 	L'identificateure de la question actuelle de la partie, sera utilis�
	 * 	pour r�cup�rer la r�ponse � la question � partir de la listes des
	 * 	questions du th�me afin de verifier si la r�ponse en cours est correcte
	 * 	dans la m�thode PartieJeu.checkChar()
	 * </p> 
	 * 
	 * @see ThemeJeu#questions
	 * @see PartieJeu#theme
	 * @see PartieJeu#checkChar(char)
	 */
	private String questionId;
	
	/**
	 * Th�me de la partie en cours
	 * 
	 * @see ThemeJeu
	 */
	private ThemeJeu theme;
  
	/**
	 * <p>
	 * 	R�ponse actuelle saisie par le joueur, mis � jours � chaque fois que le
	 * 	joueur entre une lettre
	 * </p>
	 */
	private StringBuffer currentAnswer;
	
	/**
	 * <p>
	 * 	Le pendu de cette partie, garde ces donn�es et s'occupes de le dessiner
	 *	Ses donn�es dont alt�r� dans la m�thode PartieJeu.checkCher selon si la
	 *	r�ponse du joueur est correcte ou fausse.
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
		
		int i = 0;
		while (i < theme.questions.size() 
				&& ! theme.questions.get(i).id.equals(this.questionId)) {
			i++;
		}
		
		this.currentAnswer =
				new StringBuffer(theme.questions.get(i).answer.length());
		for (i = 0; i < this.currentAnswer.capacity(); i++) {
			this.currentAnswer.insert(i, '*');
		}
	}
	
	public int getScore() {
		return score;
	}

	public Potence getHangman() {
		return hangman;
	}

	/**
	 * <b>
	 * 	Cette fonction v�rifie si le caract�re entr� par le joueur est dans la
	 *  r�ponse de la question  puis effectue des traitements selon le r�sultat
	 * </b>
	 * <p>
	 * 	Les traitement fait sont les suivant :
	 * 	<ul>
	 * 		<li>
	 * 			si le caract�re est un des caract�res de la question :
	 * 			<ol>
	 * 				<li>
	 * 					Remplace les '*' dans la r�ponse en coure aux positions
	 * 					correspondantes au caract�re donn�.
	 * 				</li>
	 *				<li>
	 *					V�rifie si la r�ponse en cours et �gale � la r�ponse de
	 *					la question si c'est le cas on consid�re la r�ponse
	 *					comme trouv�e, voir la documentation de la classe
	 *					Potence pour plus de d�tails, sinon ne fait rien.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caract�re n'est pas un des caract�res de la r�ponse
	 * 			l'�tat de la potence est incr�ment� puis la potence est 
	 * 			re-dessin�e, voir la documentation de la classe Potence pour
	 * 			plus de d�tails
	 * 		</li>
	 * </ul>
	 * </p>
	 * @param inputChar le caract�re entr�e par le joueur
	 * 
	 * @see Question
	 * @see PartieJeu#currentAnswer
	 * @see PartieJeu#theme
	 * @see PartieJeu#questionId
	 * @see com#usthb#dessin#Potence
	 */
	public void checkChar(char inputChar) {
		String answer = "";
		
		for (Question question : this.theme.questions) {
			if (question.id.equals(this.questionId)) {
				answer = new String(question.answer);
				System.out.println(question.lable);
			}
		}
		
		if (answer.indexOf(inputChar) != -1 && currentAnswer.indexOf(Character.toString(inputChar)) == -1) {//si le caract�re est dans answer
			for (int i = 0; i < answer.length(); i++) {
				if (answer.charAt(i) == inputChar) { 
					System.out.println(this.currentAnswer);
					this.currentAnswer.insert(i, inputChar);
				}
			}
			
			if (answer.equals(this.currentAnswer.toString())) {//convertie
				//currentAnswer en String puis compare avec answer
				hangman.setFoundAnswerTrue();
				
				if (this.questionId.charAt(questionId.length()) == 5) {
					System.out.println("You Won!");
				} else {
					System.out.println("level "
							+ this.questionId.charAt(questionId.length()));
					this.questionId =
							this.theme.generateQuestionID()
							+ (Integer.valueOf(this.questionId.charAt(questionId.length())) + 1);
 				}
				/*
				 * TODO open a pop-up window to tell the player that the answer
				 * is correct and give his the next question if any is
				 * available else tell him that he wont this game 
				*/
			}
		} else {
			hangman.incrementState();
			System.out.println("nah...");
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
 