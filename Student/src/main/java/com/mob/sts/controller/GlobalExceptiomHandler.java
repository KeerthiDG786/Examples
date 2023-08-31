package com.mob.sts.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mob.sts.Exception.StudentDetailsNotFound;

@RestControllerAdvice
public class GlobalExceptiomHandler extends ResponseEntityExceptionHandler {

	
//	  @Override
//	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		  Map<String,Object> body=new LinkedHashMap<>();
//	      body.put("timestamp",System.currentTimeMillis());
//	      body.put("status", status.value()); List<String>
//	      errors=ex.getBindingResult(). getFieldErrors(). stream().
//	      map(x->x.getDefaultMessage()). collect(Collectors.toList());
//	      body.put("errors", errors);
//	  
//	   return new ResponseEntity<Object>(body,status); }
	 
	
	
	
	 @ExceptionHandler(StudentDetailsNotFound.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ResponseEntity<Object> studentNotFound(StudentDetailsNotFound st,WebRequest web)
	{
		
		return new ResponseEntity<>(st.getMessage(),HttpStatus.BAD_REQUEST);
	}	 
	 HttpStatusCode status;

	  @ExceptionHandler(NoSuchElementException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) 
	  {
	   
			return new ResponseEntity<String>("error : details not found",HttpStatus.BAD_REQUEST);
	      
	  }
	
}
