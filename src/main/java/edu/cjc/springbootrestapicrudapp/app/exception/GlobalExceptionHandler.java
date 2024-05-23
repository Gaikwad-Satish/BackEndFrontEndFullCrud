package edu.cjc.springbootrestapicrudapp.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiError> productNotFoundExceptionHandler(ProductNotFoundException e,HttpServletRequest request)
	{
		System.out.println("Exception handled successfully.");
		ApiError error=new ApiError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpMessage(HttpStatus.NOT_FOUND);
		
		
		
		
		
		
		
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithematicExceptionHandler(ArithmeticException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
