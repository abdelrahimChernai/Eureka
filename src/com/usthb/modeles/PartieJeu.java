package com.usthb.modeles;

import com.usthb.dessin.Potence;

/**
 * <b>Représente une Parte du jeu et contient toutes ses données</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 */
public class PartieJeu {
	protected int number;
	
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
	protected int score;

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
	
	protected ThemeJeu theme;										//Thème sélectionné.
  
  /**
	 * Réponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentAnswer;
	
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
	private Potence hangman;
	
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
	 *					comme trouvéé, voir la documentation de la classe Potence
	 *					pour plus de détails, sinon ne fait rien.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caractère n'est pas un des caractères de la question
	 * 			l'état de la potence est incrémenté puis la potence est 
	 * 			re-dessinée, voir la documentation de la classe Potence pour plus
	 *			de détails
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
		String answer = "";
		
		for (Question question : this.theme.questions) {
			if (question.id.equals(this.questionId)) {
				answer = new String(question.answer);
			}
		}
		
		if (answer.indexOf(inputChar) != -1) {//si le caractère est dans answer
			for (int i = 0; i < answer.length(); i++) {
				if (this.currentAnswer.charAt(i) == inputChar) { 
					this.currentAnswer.insert(i, inputChar);
				}
			}
			
			if (answer.equals(this.currentAnswer.toString())) {//convertie
				//currentAnswer en String puis compare avec answer
				hangman.setFoundAnswerTrue();
				/*
				 * TODO open a pop-up window to tell the player that the answer
				 * is correct and give his the next question if any is
				 * available else tell him that he wont this game 
				*/
			}
		}
		else {
			hangman.incrementState();
			
			//TODO draw the next state of the Hangman (maybe animated)
		}
	}
}
 