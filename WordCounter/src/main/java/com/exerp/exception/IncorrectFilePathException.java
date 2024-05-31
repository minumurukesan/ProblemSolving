package com.exerp.exception;
/**
 * 
 * @author Minu M Murukesan
 *
 */
public class IncorrectFilePathException extends Exception { 

	private static final long serialVersionUID = 1L;

	public IncorrectFilePathException(String errorMessage) {
        super(errorMessage);
    }
}
