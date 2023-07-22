package com.example.kltn.SpringAPILambdaBuy.common.response;

public class StripeResponse {
	private String sessionId;

	public StripeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StripeResponse(String sessionId) {
		super();
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
