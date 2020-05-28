package com.usthb.dessin;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;


/**
 * <b>S'occupe de la gestion du pendu</b>
 * 
 * <p>
 * 	Garde l'�tat du pendu et s'ocupe de le dessiner selon cet �tat, une
 * 	Potence est instanci� dans la classe PartieJeu, voir sa documentation pour
 * 	plus de d�tails.
 * </p>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 * 
 * @see com.usthb.modeles.PartieJeu
 */
public class Potence extends Component implements Serializable{

	/**
	 * <p>
	 * 	Repr�sente l'�tat de la potence qui peut �tre entre 1 et 8, cet �tat
	 * 	correspond au nombre de tentatives effectu�es par le joueur. Lorsque
	 * 	cet �tat est �gal � 8 ou une r�ponse fausse est donn�e, un traitement
	 *  sera effectu� dans la m�thode PartieJeu.checkChar. Voir la
	 *  documentation pour plus de d�tails.
	 * </p> 
	 * 
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private int state = 8;

	/**
	 * <p>
	 * 	Repr�sente si la r�ponse en cours est �gale � la r�ponse de la question.
	 * 	Des traitement seront effectu�s dans la m�thode PartieJeu.checkChar pour
	 * 	alterer l'�tat de cette variable.
	 * </p>
	 * 
	 * @see com.usthb.modeles.Question
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.Question#answer
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private boolean foundAnswer = false;

	/**
	 * <p>
	 * 	Repr�sente les dimensions de la fen�tre (hauteur et largeur en pixels)
	 * 	qui est la surface sur laquelle le dessin sera pos�, elle sera utilis�e afin
	 * 	de dessiner le pendu au bon emplacement dans la fen�tre. Voir la
	 * 	documentation de Potence.paint pour plus de d�tails.
	 * </p>
	 * 
	 * TODO add a link to Potence.paint
	 */
	private Dimension windowDimension;

	public int getState() {
		return state;
	}

	public void clearState() {
		this.state = 8;
	}

	/**
	 * <p>
	 * 	met la variable d'instance foundAnswer a vrai indiquant que la r�ponse
	 * 	a �t� trouv�e par le joueur, ce traitement ce fait dans la m�thode
	 * 	PartieJeu.checkChar(). Voir la documentation pour plus de d�tails.
	 * </p>
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	public void setFoundAnswer() {
		this.foundAnswer = true;
	}

	/**
	 * <p>
	 * 	Incr�mente la variable state qui ne doit pas d�passer 8, la 
	 * 	verification et l'incr�mentation se font dans la m�thode
	 * 	PartieJeu.checkCher. Voir sa documentation pour plus de d�tails.
	 * </p>
	 * 
	 * @see Potence#state
	 */
	public void incrementState() {
		this.state--;
	}

	/**
	 * <p>
	 * 	Cette m�thode s'occupe de dessiner le pendu selon la variable sate, elle
	 * 	est utilis� dans la m�thode PartieJeu.checkChar
	 * </p>
	 * TODO add more details on the working of the m�thode
	 * 
	 * @param
	 */
	@Override
	public void paint(Graphics g) {
		windowDimension = this.getSize();
		
		switch (state) {
		case 0 :
			g.drawLine(l(70), h(70), l(70), h(85));
			g.drawLine(l(70), h(70), l(65), h(75));
			g.drawLine(l(70), h(70), l(75), h(75));
			g.drawLine(l(70), h(85), l(65), h(95));
			g.drawLine(l(70), h(85), l(75), h(95));
			

		case 1 :
			g.drawOval(l(65), h(60), l(10), h(10));
		
		case 2 :
			g.drawLine(l(70), h(40), l(70), h(60));
		
		case 3 :
			g.drawLine(l(30), h(60), l(50), h(40));
		
		case 4 :
			g.drawLine(l(30), h(40), l(80), h(40));
		
		case 5 :
			g.drawLine(l(60), h(120), l(30), h(90));
	
		case 6 :
			g.drawLine(l(30), h(120), l(30), h(40));
		
		case 7 :
			g.drawLine(l(30), h(120), l(90), h(120));
		}

	}
	
	private int l (int v) {
		double k = Math.min(windowDimension.width/100., windowDimension.height/110);
		return (int) (v * k);
	}
	
	private int h (int v) {
		double k = Math.min(windowDimension.width/100., windowDimension.height/110);
		return (int) (v * k);
	}
}