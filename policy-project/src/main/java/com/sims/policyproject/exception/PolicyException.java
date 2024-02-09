package com.sims.policyproject.exception;

public class PolicyException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;
	Object object;

	public PolicyException(String message) {
		super(message);
		this.message=message;
	}
	
	public PolicyException( Object object, String message) {
		super(message);
		this.object= object;
		this.message=message;
	}
	
	public String getMessage() {
        return message;
    }

}
