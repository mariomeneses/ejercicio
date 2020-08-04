package com.globallogic.ejercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globallogic.ejercicio.dto.APIErrorDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class ExceptionsAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<APIErrorDTO> badRequestException(BadRequestException ex, WebRequest request) {
		log.debug("init badRequestException");
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		APIErrorDTO apiError = buildError(ex);

		return new ResponseEntity<>(apiError, httpStatus);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIErrorDTO> handleAll(Exception ex, WebRequest request) {
		log.debug("init badRequestException");
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		APIErrorDTO apiError = buildError(ex);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	private APIErrorDTO buildError(Exception ex) {
		return APIErrorDTO.builder().mensaje(ex.getMessage()).build();
	}

}
