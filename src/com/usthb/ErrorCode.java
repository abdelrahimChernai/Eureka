package com.usthb;

public enum ErrorCode {
	WRONG_USERNAME ("Sure about that?"),
	WRONG_PASSWORD ("Wrong the password is, my young padawan"),
	WRONG_CONFIRM_PASSWORD ("Passwords don't match"),
	UNVALID_USERNAME ("Special characters can't be used"),
	UNVALID_PASSWORD ("Password too short minimaum is 4 characters"),
	UNVALID_DATE_FORMAT("Pleass make sure the format is dd mm yyyy"),
	UNVALID_NAME ("Only letters are alowed"),
	UNAVALABLE_USERNAME ("this one is not avalable, try somthing else"),
	NO_ERROR ("");
	
	String errorMessage;
	
	private ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
