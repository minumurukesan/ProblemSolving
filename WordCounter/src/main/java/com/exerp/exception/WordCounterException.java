package com.exerp.exception;
/**
 * 
 * @author Minu M Murukesan
 *
 */
public class WordCounterException extends Exception { 

	private static final long serialVersionUID = 1L;

	public WordCounterException(String errorMessage) {
		super(errorMessage);
	}
}
