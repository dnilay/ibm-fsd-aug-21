package com.example.demo.exception;

public class ErrorResponseModel {
	
	private String errorMessage;
	private Integer statusCode;
	private Long errorReportingTime;
	public ErrorResponseModel() {
		
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Long getErrorReportingTime() {
		return errorReportingTime;
	}
	public void setErrorReportingTime(Long errorReportingTime) {
		this.errorReportingTime = errorReportingTime;
	}
	

}
