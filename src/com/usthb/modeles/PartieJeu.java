package com.usthb.modeles;

/**
 * @author Abdelrahim Chernai
 *
 */
public class PartieJeu {
	protected int number;											//Numéro associé.
	protected int score;											//Score actuelle.
	//TODO add question number or question id when clarified.
	protected ThemeJeu theme;										//Thème sélectionné.
	protected StringBuffer currentAnswer;							//Réponse actuelle Saisie par le joueur.
	
	/**
	 * <b>
	 * 	Cette fonction vérifie si le caractère entrée par le joueur est dans le
	 *  réponse de la question  puis effectue des traitements selon le résultat
	 * </b>
	 * <p>
	 * 	Les traitement fait sont les suivant :
	 * 	<ul>
	 * 		<li>
	 * 			si le caractère est un des caractères de la question :
	 * 			<ol>
	 * 				<li>
	 * 					Remplace les '*' dans la réponse en coure au positions
	 * 					trouvées par le caractère donné.
	 * 				</li>
	 *				<li>
	 *					Vérifie si la réponse en cours et égale a la réponse de
	 *					la question si c'est le cas on considère la réponse
	 *					comme trouvé voir la documentation de la class Potence
	 *					Pour plus de détailles, sinon ne fait rein.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caractère n'est pas un des caractères de la question
	 * 			l’état de la potence est incrémenté puis la potence est 
	 * 			re-dessinée voir la documentation de la class Potence Pour plus
	 *			de détailles
	 * 		</li>
	 * </ul>
	 * </p>
	 * @param inputChar le caractère entrée par le joueur
	 * 
	 * @see Question
	 * @see PartieJeu#currentAnswer
	 * @see PartieJeu#theme
	 * TODO add a link to QuestionID
	 * @see com#usthb#dessin#Potence
	 */
	public void checkChar(char inputChar) {
		String answer = "";
		//TODO find the question in the theme using the number of the question and set answer 
		
		if (answer.indexOf(inputChar) != -1) {//si le caractère est dans answer
			for (int i = 0; i < answer.length(); i++) {
				if (this.currentAnswer.charAt(i) == inputChar) { 
					this.currentAnswer.insert(i, inputChar);
				}
			}
			
			if (answer.equals(this.currentAnswer.toString())) {//convertie
				//currentAnswer en String puis compare avec answer
				/*
				 * TODO set the instance variable of Potence fondAnswer to
				 * true
				*/
				
				/*
				 * TODO open a pop-up window to tell the player that the answer
				 * is correct and give his the next question if any is
				 * available else tell him that he wont this game 
				*/
			}
		}
		else {
			//TODO increment the instance variable of Potence state
			
			//TODO draw the next state of the Hangman (maybe animated)
		}
	}
}
 