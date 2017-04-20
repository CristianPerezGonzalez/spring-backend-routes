package org.myproject.front.rest.exception;

/**
 * Excepcion que representa el error que se produce cuando no se encuentra un
 * determinado elemento
 * 
 * @author Capgemini
 * @version 1.0
 * @since 2016
 */
public class BadRequestException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 5006813471828321098L;

	/**
	 * Constructor con parametros
	 * 
	 * @param message
	 */
	public BadRequestException(String message) {
		super(message);
	}

}
