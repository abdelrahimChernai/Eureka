package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;

public class Enfant extends Joueur {

	public Enfant(String firstName
			, String lastName
			, String username
			, String password
			, Date birthDate) {
		
		super(firstName, lastName, username, password, birthDate);
	}

	@Override
	public LinkedList<QuestionEnfant> getQuestions(ThemeJeu theme) {
		LinkedList<QuestionEnfant> questions = new LinkedList<QuestionEnfant>();
		
		for (Question question : theme.getQuestions()) {
			if (question.getClass().equals(QuestionEnfant.class)) {
				questions.add((QuestionEnfant) question);
			}
		}
		
		return questions;
	}

}
