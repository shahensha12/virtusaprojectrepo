package org.virtusa.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler(NumberFormatException n) {
		
		return "Enter value in valid Number Format";
	}
	@ExceptionHandler(NullPointerException.class)
	public String nullexceptionHandler(NullPointerException n) {
		
		return "null value";
	}
	
}
