package com.usthb.modeles;

/**
 * <b>Represent les niveaux du jeu.</b>
 * <p>
 * 	Les niveaux, actuellement au nombre de 5, sont représenté ici et chacun 
 * 	associé aux point qu'il vaut afin, ces point seront utilisés dans la class
 * 	Joueur et Question.
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
 * @version 1.0
 */
public enum Levels {
	LEVEL_1 (5),
	LEVEL_2 (10),
	LEVEL_3 (18),
	LEVEL_4 (28),
	LEVEL_5 (40);
	
	/**
	 * <p>
	 * Represent les points que vaut le niveau voir documentation de Levels
	 * pour valeurs exactes.
	 * </p>
	 * 
	 * @see Levels
	 */
	public int lvlPoints;
	
	/**
	 * Le Constructeur d'un Levels.
	 * @param lvlPoints les point que vaut le niveaux ces dernier sont précisés
	 * 	au début de la documentation de Levels
	 * 
	 * @see Lvels
	 * 
	 * @see Levels#lvlPoints()
	 */
	Levels(int lvlPoints) {
		this.lvlPoints = lvlPoints;
	}
}
