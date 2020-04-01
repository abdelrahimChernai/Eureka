/**
 * 
 */
package com.usthb.dessin;

/**
 * @author Abdelrahim Chernai
 *
 */
@SuppressWarnings("serial") //ignore this line
public class Potence extends Component{
	
	/**
	 * <p>
	 * 	Repr�sente l'etat de la potence qui peut �tre entre 1 et 8 cet �tat
	 * 	correspond au nombre de tentative effectu� par le joueur lors ce que
	 * 	cet �tat est �gale a 8 ou une fausse r�ponse est donn�e un traitement
	 *  sera effectuer dans la m�thode PartieJeu.checkChar voir �a
	 *  documentation pour plus de d�tailles.
	 * </p> 
	 * 
	 * @see com.usthb.modeles.PartieJeu
	 * 
	 * @see com.usthb.modeles.PartieJeu#checkChar(char)
	 */
	private int state;
	
	/**
	 * <p>
	 * 	Repr�sente si la r�ponse en cours est �gale a la r�ponse de la question
	 * 	des traitement seront effectuer dans la m�thode PartieJeu.checkChar pour
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
	 * 	Repr�sente les dimensions de la fen�tre (hauteur et largeur en pixels)
	 * 	qui est la surface sur la quelle le dessin sera pos�e sera utiliser afin
	 * 	de dessiner le pendu au bonne emplacement dans la fen�tre. voir la
	 * 	documentation de Potence.paint pour plus de d�tailles.
	 * </p>
	 * 
	 * TODO add a link to Potence.paint
	 */
	private Dimension windowDimension;
	
	/**
	 * <p>
	 * 	Ajoute un � la variable state qui ne doit pas d�passer 8 la 
	 * 	verification et l'incr�mentation se fait dans la m�thode
	 * 	PartieJeu.checkCher voir sa documentation pour plus de d�tailles
	 * </p>
	 * 
	 * @see Potence#state
	 */
	public void incrementState() {
		this.state++;
	}
	
	/**
	 * <p>
	 * 	Cette m�thode s'occupe de dessiner le pendu selon la variable sate elle
	 * 	est utilis� dans la m�thode PartieJeu.checkChar
	 * </p>
	 * TODO add more details on the working of the m�thode
	 * 
	 * @param
	 */
	public void paint(Graphics hamgmanDrawManager) {
		
	}