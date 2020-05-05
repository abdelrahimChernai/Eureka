package com.usthb.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

import com.usthb.MainApp;

/**
 * <b>Joueur est la classe repr�sentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.2.0
 * @see ParieJeu
 */
public class Joueur implements Serializable{
  
  /**
	 * <p>
	 *  Num�ro s�quentiel automatique unique caract�risant le joueur et utilis�
	 *  comme cl� pour acc�der aux informations du joueur dans la liste des 
	 *  joueurs.
	 * </p>
	 * 
	 * <p>
	 * 	Pour plus d'informations sur la liste des joueur, voir la documentation
	 * 	de la class MainApp.players
	 * </p>
	 * 
	 * @see com.usthb.MainApp#players
	 */
	private int id;
	
	/**
     * <p>
	 *  Le niveau le plus r�cent du joueur est celui atteint lors de derni�re 
	 *  partie jou�e, chaque niveau d�bloqu� offre un certain nombre de points
	 *  et permet au joueur de reprendre la partie au m�me niveau.
	 * </p>
	 * 
	 * @see Joueur#hashCode(String)
	 * 
	 * @see Joueur#username
	 * 
	 * @see Levels
	 * 
	 * @since 1.1.0
	 */
	private Levels currentLvl;
  
	/**
	 * <p>
	 * 	Repr�sente le Nom du joueur, est demand� lors de son inscription
	 * </p>
	 */
	private String lastName;
  
	/**
	 * <p>
	 * 	Repr�sente le Pr�nom du joueur, est demand� lors de son inscription
	 * </p>
	 */
	private String firstName;
  
	/**
	 * <p>
	 * 	Le nom d'utilisateur � partir duquel on g�n�re un id unique, cette
	 * 	unicit� est assur� car lors de la r�cup�ration de ce nom d'utilisateur
	 *  on g�n�re un id et on v�rifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur d'en saisir un autre, est aussi utilis� lors de la
	 *  connection de joueur.
	 * </p>
	 * 
	 * @see Joueur#hashCode(String)
	 * 
	 * @see Joueur#id
	 */
	private String username;
  
	/**
	 * <p>
	 * 	On l'utilise lors de la connexion du joueur pour s'assurer de son
	 * 	identit�.
	 * </p>
	 */
	private String password;
  
	/**
	 * La date de naissance du joueur.
	 */
	private Date birthDate;
	
	/**
	 * <p>
	 * 	Historique des parties jou�es par le joueur depuis qu'il s'est inscrit
	 * 	utilis� aussi pour calculer le score totale du joueur
	 * </p>
	 * 
	 * @see PartieJeu
	 * 
	 * @see Joueur#getTotalScore()
	 */
	private LinkedList<PartieJeu> playerGames;
	
	
	/**
	 * <p>
	 * 	Un constructeur qui prend tout les param�tres du joueur, ce dernier est
	 * 	utilis� dans {@link MainApp#connection()}.
	 * </p>
	 * 
	 * @param firstName le pr�nom du joueur
	 * @param lastName le nom du joueur
	 * @param username le nom d'utilisateur du joueur qui est unique ,cette
	 * 	unicit� est assur� lors de la creation du joueur, voir la documentation
	 * 	de {@link MainApp#inscription()} et {@link Joueur#username}.
	 * @param password le mot de passe du joueur utilis� pour plus de s�curit�
	 * @param birthDate la date de naissance du joueur, une verification doit
	 * 	�tre faite pour s'assurer du format de la date, voir la documentation
	 * 	de {@link Joueur#isDateValide(Date)}
	 * 
	 * @see Joueur#isDateValide(Date)
	 * @see MainApp#connection()
	 * @see MainApp#inscription()
	 * 
	 * @see Joueur#username
	 */
	public Joueur(
				String firstName
				, String lastName
				, String username
				, String password
				, Date birthDate
			) {
		
		this.id = hashCode(username);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.playerGames = new LinkedList<PartieJeu>();
	}
	
	/**
	 * R�cup�re le num�ro s�quentiel du joueur
	 * @return num�ro s�quentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	public void setCurrentLvl(Levels currentLvl) {
		this.currentLvl = currentLvl;
	}

	/**
	 * <p>
	 * 	Utilise la fonction de Objects pour cr�er un Num�ro s�quentiel et
	 * 	utilise la fonction Math.Abs pour s'assurer que id >= 0 vu qu'il est
	 * 	utilis� pour acc�der � la liste des joueurs, voir les m�thodes
	 * 	connection et inscription
	 * </p>
	 * 
	 * @return un num�ro s�quentielle qui identifie le joueur
	 * 
	 * @see com.usthb.MainApp#connection()
	 * @see com.usthb.MainApp#inscription()
	 */
	public static int hashCode(String username) {
		return Math.abs(Objects.hash(username));
	}
	
	
	/**
	 * Initialise le nom du joueur
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * R�cup�re le pr�nom du joueur
	 * @return Le pr�nom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * R�cup�re le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * R�cup�re le mot de passe du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
		
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale calcul� � partir de la liste des parties jou�es.
	 * 
	 * @see PartieJeu
	 * 
	 * @see Joueur#playerGames
	 */
	public int getTotalScore() {
		int totalScore = 0;
		
		for (PartieJeu game : this.playerGames) {
			totalScore += game.getScore();
		}
		return totalScore;
	}
	
	/**
	 * <b>Ajoute une partie a la liste des parties du joueur</b>
	 * 
	 * @param partie la partie a ajouter
	 */
	public void addGame(PartieJeu partie) {
		this.playerGames.add(partie);
	}

	/**
	 * <p>
	 * 	Versifie si une date est correcte selon les normes du calendrier
	 * 	gr�gorien en v�rifiant la valeur des jours selon les mois et si l'ann�e
	 * 	est bissextile ou pas.
	 * </p>
	 * @param date une date a verifier
	 * @return	true si cette date est une date du calendrier gr�gorien
	 */
	public static boolean isDateValide(Date date) {
		if (
				date.getYear() >= 0
				&& date.getMonth() <= 12
				&& date.getMonth() >= 1
				&& date.getDate() >= 1
			) {
			
			switch (date.getMonth() + 1) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
					if (date.getDate() <= 31) {
						return true;
					} else {
						return false;
					}

				case 4: case 6: case 9: case 11:
					if (date.getDate() <= 30) {
						return true;
					} else {
						return false;
					}

				case 2 :
					if (
							(
								(date.getYear() % 4 == 0)
								&& (date.getYear() % 100 != 0)
							)
							
							|| (
								date.getYear() % 400 == 0
							)
						) {
						
						if(date.getDate() <= 29) {
							return true;
						} else {
							return false;
						}
							
					} else {
						if(date.getDate() <= 28) {
							return true;
						} else {
							return false;
						}
					}
				
				default :
					return false;
			}
			
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Player #" + id + ": "
				+ firstName + " "
				+ lastName + " Date of birth "
				+ birthDate + " Username: "
				+ username + " Level "
				+ currentLvl + " : "
				+ this.getTotalScore() + " points";
	}
	
}