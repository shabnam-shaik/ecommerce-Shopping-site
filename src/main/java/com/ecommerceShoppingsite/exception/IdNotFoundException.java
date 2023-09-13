package com.ecommerceShoppingsite.exception;

public class IdNotFoundException extends RuntimeException {

	String message="Given id doesnt exist";

	
	public IdNotFoundException() {
		super();
	}


	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}
	

}
