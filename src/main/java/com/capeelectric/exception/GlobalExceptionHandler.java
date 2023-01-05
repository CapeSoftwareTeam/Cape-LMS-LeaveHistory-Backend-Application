package com.capeelectric.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capeelectric.util.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ ApplyLeaveException.class })
	public ResponseEntity<ErrorMessage> handleApplyLeaveException(ApplyLeaveException e) {
		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ErrorMessage> handleException(Exception e) {
		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "402");
		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}

}
