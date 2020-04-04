package com.usthb.modeles;

/**
 * <b>Contient les types possible d'un thème</b>
 * 
 *@see ThemeJeu
 *
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.0
 */
public enum ThemeType {
	HISTOIRE ("HIS"),
	GEOGRAPHIE ("GEO"),
	SANTE ("SAN"),
	CULTURE_GENERALE ("CUL"),
	ISLAM ("ISL");
	
	private String abreviation;
	
	private ThemeType(String abreviation) {
		this.abreviation = abreviation;
	}
	
	public String getAbreviation() {
		return this.abreviation;
	}
}
