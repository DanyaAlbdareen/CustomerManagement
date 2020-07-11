package com.jsfProject.type;

public class ReturnMessage {
	private String message=" ";
	//private String message_ar=" ";
	private int response_code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/*
	public String getMessage_ar() {
		return message_ar;
	}
	public void setMessage_ar(String message_ar) {
		this.message_ar = message_ar;
	}*/
	public int getResponse_code() {
		return response_code;
	}
	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}
	
	
}
