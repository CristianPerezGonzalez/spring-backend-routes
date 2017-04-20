package org.myproject.front.rest.exception.handler;

import org.myproject.front.rest.exception.ErrorResponseDTO;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Handler para tratar las excepciones lanzadas por los servicios REST
 * 
 * @author Capgemini
 * @version 1.0
 * @since 2016
 */
@ControllerAdvice
public class RestExceptionHandler {

	/**
	 * Gestiona los errores 500
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponseDTO handleRuntimeException(RuntimeException exception) {

		return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error",
				exception.getMessage());

	}

	/**
	 * Gestiona los errores lanzados como NotFoundException
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponseDTO handleNotFoundException(NotFoundException exception) {

		return new ErrorResponseDTO(HttpStatus.NOT_FOUND.value(), "Not Found Error", exception.getMessage());

	}
	
	/**
	 * Gestiona los errores lanzados como NoContentException
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public ErrorResponseDTO handleNoContentException(NoContentException exception) {

		return new ErrorResponseDTO(HttpStatus.NO_CONTENT.value(), "No Content Error", exception.getMessage());

	}
	
	/**
	 * Gestiona los errores lanzados como BadRequestException
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponseDTO handleBadRequestException(NoContentException exception) {

		return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), "Bad Request Error", exception.getMessage());

	}

}
