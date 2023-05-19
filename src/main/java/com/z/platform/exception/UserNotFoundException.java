package com.z.platform.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
        super("Customer not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
