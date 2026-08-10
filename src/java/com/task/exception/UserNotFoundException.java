package com.task.exception;

/**
 * Custom exception thrown when a user (candidate/employer)
 * is not found in the database, e.g. invalid login or invalid user id.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}