package com.renta.app.payload.response;

public class MessageResponse {
	
	
	private String message;
	private String success;

	

	

	public MessageResponse(String message, String success) {
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
