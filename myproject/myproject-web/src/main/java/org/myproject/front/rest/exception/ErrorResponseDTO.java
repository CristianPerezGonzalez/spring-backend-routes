package org.myproject.front.rest.exception;

import lombok.Data;

/**
 * DTO que representa una respuesta de error
 * 
 * @author Capgemini
 * @version 1.0
 * @since 2016
 */
@Data
public class ErrorResponseDTO {

	private int status;
	private String message;
	private String description;

	/**
	 * Constructor por defecto
	 */
	public ErrorResponseDTO() {

	}

	/**
	 * Constructor con parametros
	 * 
	 * @param status
	 * @param message
	 * @param description
	 */
	public ErrorResponseDTO(int status, String message, String description) {

		this.status = status;
		this.message = message;
		this.description = description;

	}
}
