package com.usthb.modeles;

import java.io.Serializable;
import java.util.HashMap;

/**
 * <b>Represent les niveaux du jeu.</b>
 * <p>
 * 	Les niveaux, actuellement au nombre de 5, sont représentés ici. Chaque
 * 	niveau est associé au nombre de points qu'il vaut, ces points seront
 * 	utilisés dans la classe Joueur et Question.
 * </p>
 * <ul>
 * 	<li>Le niveau 1 donne 5 points</li>
 * 	<li>Le niveau 2 donne 10 points</li>
 * 	<li>Le niveau 3 donne 18 points</li>
 * 	<li>Le niveau 4 donne 28 points</li>
 * 	<li>Le niveau 5 donne 40 points</li>
 * </ul>
 * 
 * @see Joueur
 * @see Question
 * 
 * @see Question#getNumberPoints()
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.1.0
 */
public enum Levels implements Serializable {
	NO_LEVEL(0, 0),
	LEVEL_1 (5, 1),
	LEVEL_2 (10, 2),
	LEVEL_3 (18, 3),
	LEVEL_4 (28, 4),
	LEVEL_5 (40, 5);
	
	/**
	 * <p>
	 * Représente les points que vaut le niveau, voir documentation de Levels
	 * pour les valeurs exactes.
	 * </p>
	 * 
	 * @see Levels
	 */
	public int lvlPoints;
	private int lvlNumber;
	private static final HashMap<Integer, Levels> levelNumberCorespendance =
			new HashMap<Integer, Levels>();
	
	static {
		for (Levels level : Levels.values()) {
			levelNumberCorespendance.put(level.lvlNumber, level);
		}
	}
	
	/**
	 * Le Constructeur d'un Levels.
	 * @param lvlPoints représente le nombre de points que vaut le niveau, ce
	 * 	dernier est précisé au début de la documentation de Levels
	 * 
	 * @see Lvels
	 * 
	 * @see Levels#lvlPoints()
	 */
	private Levels(int lvlPoints, int lvlNumber) {
		this.lvlPoints = lvlPoints;
		
		/**
		 * @since 1.1.0
		 */
		this.lvlNumber = lvlNumber;
	}
	
	/**
	 * @since 1.1.0
	 */
	public static Levels  getLvl(int lvlNumber) {
		return Levels.levelNumberCorespendance.get(lvlNumber);
	}
	
	/**
	 * @since 1.1.0
	 */
	public int getLvlNumber() {
		return this.lvlNumber;
	}
}
