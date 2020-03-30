/**
 * 
 */
package com.usthb.modeles;

import java.util.LinkedList;

/**
 * @author Abdelrahim Chernai
 *
 */
public class ThemeJeu {
	protected int coefficent;						//Coefficient.
	protected String lable;							//Libellé.
	protected LinkedList <Question> questions;		//Liste des questions.
	
	/**
	 * Le type du thème.
	 * <p>
	 * 	Pour plus d'unfirmation sur les valeurs possible voir documentation de
	 * 	l'enumeration ThemeType
	 * </p>
	 * 
	 * @see ThemeType
	 */
	protected ThemeType type;
	
}
