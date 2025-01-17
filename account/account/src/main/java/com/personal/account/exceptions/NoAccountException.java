package com.personal.account.exceptions;

@SuppressWarnings("serial")
public class NoAccountException extends RuntimeException{
	
	public NoAccountException(String s) {
		super(s);
	}

}
