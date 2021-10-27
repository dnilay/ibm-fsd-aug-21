package com.example.demo.exception;

public class CouponNotFoundException extends Exception {
	
	private String message;

	public CouponNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
