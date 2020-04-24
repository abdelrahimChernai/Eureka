package com.usthb;

public enum ErrorCode {
	WRONG_USERNAME ("Sure about that?"),
	WRONG_PASSWORD ("Wrong the password is, my young padawan");
	
	String errorMessage;
	
	private ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
