package com.personal.account.exceptions;

import java.time.LocalDateTime;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.personal.account.dto.ErrorDto;

@RestControllerAdvice()
public class AccountsExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex){
		return new ResponseEntity(new ErrorDto(HttpStatus.SC_INTERNAL_SERVER_ERROR, ex.getMessage(),LocalDateTime.now()),HttpStatusCode.valueOf(500));
	}
	
}
