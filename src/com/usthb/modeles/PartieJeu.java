package com.usthb.modeles;

import com.usthb.dessin.Potence;

/**
 * <b>Repr�sente une Parte du jeu et contient toutes ses donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 */
public class PartieJeu {
	protected int number;
	
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
	protected int score;

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
	
	protected ThemeJeu theme;										//Th�me s�lectionn�.
  
  /**
	 * R�ponse actuelle saisie par le joueur.
	 */
	protected StringBuffer currentAnswer;
	
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
	private Potence hangman;
	
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
	 *					comme trouv��, voir la documentation de la classe Potence
	 *					pour plus de d�tails, sinon ne fait rien.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caract�re n'est pas un des caract�res de la question
	 * 			l'�tat de la potence est incr�ment� puis la potence est 
	 * 			re-dessin�e, voir la documentation de la classe Potence pour plus
	 *			de d�tails
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
			}
		}
		
		if (answer.indexOf(inputChar) != -1) {//si le caract�re est dans answer
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
 