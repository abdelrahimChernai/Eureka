package com.usthb.dessin;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * <b>S'occupe de la gestion du pendu</b>
 * 
 * <p>
 * 	Garde l'etat du pendu et s'ocupe de le dessiner selon cette état, une
 * 	Potence est instancié dans la class PartieJeu, voir sa documentation pour
 * 	plus de détailles.
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @version 1.0
 * 
 * @see com.usthb.modeles.PartieJeu
 */
@SuppressWarnings("serial") //ignore this line
public class Potence extends Component{
	
	/**
	 * <p>
	 * 	Représente l'etat de la potence qui peut être entre 1 et 8 cet état
	 * 	correspond au nombre de tentative effectué par le joueur lors ce que
	 * 	cet êtat est ï¿½gale a 8 ou une fausse réponse est donnée un traitement
	 *  sera effectuer dans la méthode PartieJeu.checkChar voir ï¿½a
	 *  documentation pour plus de détailles.
	 * </p> 
	 * 
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private int state;
	
	/**
	 * <p>
	 * 	Représente si la réponse en cours est ï¿½gale a la réponse de la question
	 * 	des traitement seront effectuer dans la méthode PartieJeu.checkChar pour
	 * 	alterer l'etat de cette variable.
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
	 * 	qui est la surface sur la quelle le dessin sera posée sera utiliser afin
	 * 	de dessiner le pendu au bonne emplacement dans la fenêtre. voir la
	 * 	documentation de Potence.paint pour plus de détailles.
	 * </p>
	 * 
	 * TODO add a link to Potence.paint
	 */
	private Dimension windowDimension;
	
	/**
	 * <p>
	 * 	Ajoute un ï¿½ la variable state qui ne doit pas dï¿½passer 8 la 
	 * 	verification et l'incrémentation se fait dans la méthode
	 * 	PartieJeu.checkCher voir sa documentation pour plus de détailles
	 * </p>
	 * 
	 * @see Potence#state
	 */
	public void incrementState() {
		this.state++;
	}
	
	/**
	 * <p>
	 * 	Cette méthode s'occupe de dessiner le pendu selon la variable sate elle
	 * 	est utilisé dans la méthode PartieJeu.checkChar
	 * </p>
	 * TODO add more details on the working of the méthode
	 * 
	 * @param
	 */
	public void paint(Graphics hamgmanDrawManager) {
		
	}