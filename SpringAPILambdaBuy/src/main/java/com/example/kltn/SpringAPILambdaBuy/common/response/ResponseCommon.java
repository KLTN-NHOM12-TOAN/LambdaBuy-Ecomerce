package com.example.kltn.SpringAPILambdaBuy.common.response;

public class ResponseCommon<T> {
	public boolean success;
    public int code;
    public String message;
    public String errorMessage;
    public T data;
    
    
	public ResponseCommon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseCommon(boolean success, int code, String message, String errorMessage, T data) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.errorMessage = errorMessage;
		this.data = data;
	}
	
	public ResponseCommon(int code, boolean success, String message, T data) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public ResponseCommon(int code, boolean success, String message) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseCommon [success=" + success + ", code=" + code + ", message=" + message + ", errorMessage="
				+ errorMessage + ", data=" + data + "]";
	}    
	
}
