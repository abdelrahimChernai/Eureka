package com.usthb.dessin;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * <b>S'occupe de la gestion du pendu</b>
 * 
 * <p>
 * 	Garde l'état du pendu et s'ocupe de le dessiner selon cet état, une
 * 	Potence est instancié dans la classe PartieJeu, voir sa documentation pour
 * 	plus de détails.
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 * 
 * @see com.usthb.modeles.PartieJeu
 */
public class Potence extends Component{
	
	/**
	 * <p>
	 * 	Représente l'état de la potence qui peut être entre 1 et 8, cet état
	 * 	correspond au nombre de tentatives effectuées par le joueur. Lorsque
	 * 	cet état est égal à 8 ou une réponse fausse est donnée, un traitement
	 *  sera effectué dans la méthode PartieJeu.checkChar. Voir la
	 *  documentation pour plus de détails.
	 * </p> 
	 * 
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private int state;
	
	/**
	 * <p>
	 * 	Représente si la réponse en cours est égale à la réponse de la question.
	 * 	Des traitement seront effectués dans la méthode PartieJeu.checkChar pour
	 * 	alterer l'état de cette variable.
	 * </p>
	 * 
	 * @see com.usthb.modeles.Question
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.Question#answer
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private boolean foundAnswer;
	
	/**
	 * <p>
	 * 	Représente les dimensions de la fenêtre (hauteur et largeur en pixels)
	 * 	qui est la surface sur laquelle le dessin sera posé, elle sera utilisée afin
	 * 	de dessiner le pendu au bon emplacement dans la fenêtre. Voir la
	 * 	documentation de Potence.paint pour plus de détails.
	 * </p>
	 * 
	 * TODO add a link to Potence.paint
	 */
	private Dimension windowDimension;
	
	
	/**
	 * <p>
	 * 	met la variable d'instance foundAnswer a vrai indiquant que la réponse
	 * 	a été trouvée par le joueur, ce traitement ce fait dans la méthode
	 * 	PartieJeu.checkChar(). Voir la documentation pour plus de détails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	public void setFoundAnswerTrue() {
		this.foundAnswer = true;
	}
	
	/**
	 * <p>
	 * 	Incrémente la variable state qui ne doit pas dépasser 8, la 
	 * 	verification et l'incrémentation se font dans la méthode
	 * 	PartieJeu.checkCher. Voir sa documentation pour plus de détails.
	 * </p>
	 * 
	 * @see Potence#state
	 */
	public void incrementState() {
		this.state++;
	}
	
	/**
	 * <p>
	 * 	Cette méthode s'occupe de dessiner le pendu selon la variable sate, elle
	 * 	est utilisé dans la méthode PartieJeu.checkChar
	 * </p>
	 * TODO add more details on the working of the méthode
	 * 
	 * @param
	 */
	public void paint(Graphics hamgmanDrawManager) {
		
	}
}