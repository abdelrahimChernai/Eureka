package com.usthb.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

import com.usthb.MainApp;

/**
 * <b>Joueur est la classe représentant un joueur.</b>
 * 
 * @author Abdelrahim Chernai
 * @author Yasmine Bouamra
 * @version 1.2.0
 * @see ParieJeu
 */
public class Joueur implements Serializable{
  
  /**
	 * <p>
	 *  Numéro séquentiel automatique unique caractérisant le joueur et utilisé
	 *  comme clé pour accéder aux informations du joueur dans la liste des 
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
	 *  Le niveau le plus récent du joueur est celui atteint lors de dernière 
	 *  partie jouée, chaque niveau débloqué offre un certain nombre de points
	 *  et permet au joueur de reprendre la partie au même niveau.
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
	 * 	Représente le Nom du joueur, est demandé lors de son inscription
	 * </p>
	 */
	private String lastName;
  
	/**
	 * <p>
	 * 	Représente le Prénom du joueur, est demandé lors de son inscription
	 * </p>
	 */
	private String firstName;
  
	/**
	 * <p>
	 * 	Le nom d'utilisateur à  partir duquel on génère un id unique, cette
	 * 	unicité est assuré car lors de la récupération de ce nom d'utilisateur
	 *  on génère un id et on vérifie qu'il n'existe pas, si c'est le cas on
	 *  demande au joueur d'en saisir un autre, est aussi utilisé lors de la
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
	 * 	identité.
	 * </p>
	 */
	private String password;
  
	/**
	 * La date de naissance du joueur.
	 */
	private Date birthDate;
	
	/**
	 * <p>
	 * 	Historique des parties jouées par le joueur depuis qu'il s'est inscrit
	 * 	utilisé aussi pour calculer le score totale du joueur
	 * </p>
	 * 
	 * @see PartieJeu
	 * 
	 * @see Joueur#getTotalScore()
	 */
	private LinkedList<PartieJeu> playerGames;
	
	
	/**
	 * <p>
	 * 	Un constructeur qui prend tout les paramètres du joueur, ce dernier est
	 * 	utilisé dans {@link MainApp#connection()}.
	 * </p>
	 * 
	 * @param firstName le prénom du joueur
	 * @param lastName le nom du joueur
	 * @param username le nom d'utilisateur du joueur qui est unique ,cette
	 * 	unicité est assuré lors de la creation du joueur, voir la documentation
	 * 	de {@link MainApp#inscription()} et {@link Joueur#username}.
	 * @param password le mot de passe du joueur utilisé pour plus de sécurité
	 * @param birthDate la date de naissance du joueur, une verification doit
	 * 	être faite pour s'assurer du format de la date, voir la documentation
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
	 * Récupère le numéro séquentiel du joueur
	 * @return numéro séquentiel du joueur
	 */
	public int getId() {
		return this.id;
	}
	
	public void setCurrentLvl(Levels currentLvl) {
		this.currentLvl = currentLvl;
	}

	/**
	 * <p>
	 * 	Utilise la fonction de Objects pour créer un Numéro séquentiel et
	 * 	utilise la fonction Math.Abs pour s'assurer que id >= 0 vu qu'il est
	 * 	utilisé pour accéder à  la liste des joueurs, voir les méthodes
	 * 	connection et inscription
	 * </p>
	 * 
	 * @return un numéro séquentielle qui identifie le joueur
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
	 * Récupère le prénom du joueur
	 * @return Le prénom du joueur
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Récupère le user name du joueur
	 * @return le user name du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Récupère le mot de passe du joueur
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
		
	/**
	 * Donne le nombre de points du joueur depuis son inscription 
	 * @return le score totale calculé à partir de la liste des parties jouées.
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
	 * 	grégorien en vérifiant la valeur des jours selon les mois et si l'année
	 * 	est bissextile ou pas.
	 * </p>
	 * @param date une date a verifier
	 * @return	true si cette date est une date du calendrier grégorien
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