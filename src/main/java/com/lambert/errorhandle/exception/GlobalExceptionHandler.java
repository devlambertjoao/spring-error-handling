package com.lambert.errorhandle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<Object> handleBusinessException(BusinessException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler({ InvalidArgumentsException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(InvalidArgumentsException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler({ NumberFormatException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleNumberFormatException(NumberFormatException exception) {
		return new ResponseEntity<>("Value passed on path variable is invalid!", HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleDefaultException(Exception exception) {
		exception.printStackTrace();
		return new ResponseEntity<>("Unexpected Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}