package com.usthb.modeles;

/**
 * <b>Repr�sente une Parte du jeu et contient toutes ses donn�es</b>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 */
public class PartieJeu {
	protected int number;
	
	/**
	 * <p>
	 * 	Le score collect� par le joueur durant la partie, est calculer en
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
	 * <b>
	 * 	Cette fonction v�rifie si le caract�re entr�e par le joueur est dans le
	 *  r�ponse de la question  puis effectue des traitements selon le r�sultat
	 * </b>
	 * <p>
	 * 	Les traitement fait sont les suivant :
	 * 	<ul>
	 * 		<li>
	 * 			si le caract�re est un des caract�res de la question :
	 * 			<ol>
	 * 				<li>
	 * 					Remplace les '*' dans la r�ponse en coure au positions
	 * 					trouv�es par le caract�re donn�.
	 * 				</li>
	 *				<li>
	 *					V�rifie si la r�ponse en cours et �gale a la r�ponse de
	 *					la question si c'est le cas on consid�re la r�ponse
	 *					comme trouv� voir la documentation de la class Potence
	 *					Pour plus de d�tailles, sinon ne fait rein.
	 *				</li>
	 * 			</ol>
	 * 		</li>
	 * 		<li>
	 * 			si le caract�re n'est pas un des caract�res de la question
	 * 			l'�tat de la potence est incr�ment� puis la potence est 
	 * 			re-dessin�e voir la documentation de la class Potence Pour plus
	 *			de d�tailles
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
		//TODO find the question in the theme using the number of the question and set answer 
		
		if (answer.indexOf(inputChar) != -1) {//si le caract�re est dans answer
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
 