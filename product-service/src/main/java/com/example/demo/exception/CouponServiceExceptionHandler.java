package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponServiceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handlecouponNotFoundException(CouponNotFoundException e) {

		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setErrorMessage(e.getMessage());
		errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
		errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleEmptyListException(EmptyListException e) {

		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setErrorMessage(e.getMessage());
		errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
		errorResponseModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseModel);
	}

}
