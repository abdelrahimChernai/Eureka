package com.usthb.modeles;

import java.util.Date;
import java.util.LinkedList;

public class Adulte extends Joueur {

	public Adulte(
			String firstName
			, String lastName
			, String username
			, String password
			, Date birthDate) {
		
		super(firstName, lastName, username, password, birthDate);
	}

	@Override
	LinkedList<QuestionAdulte> getQuestions(ThemeJeu theme) {
		LinkedList<QuestionAdulte> questions = new LinkedList<QuestionAdulte>();
		
		for (Question question : theme.getQuestions()) {
			if (question.getClass().equals(QuestionAdulte.class)) {
				questions.add((QuestionAdulte) question);
			}
		}
		
		return questions;
	}

}
