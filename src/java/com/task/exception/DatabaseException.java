package com.task.exception;

/**
 * Custom exception thrown when a database operation fails
 * (connection issue, query failure, etc.)
 */
public class DatabaseException extends Exception {

    public DatabaseException() {
        super("Database operation failed.");
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}