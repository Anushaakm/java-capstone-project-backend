package com.anu.capstone.exception;

public class JobApplicationException extends RuntimeException{
    public JobApplicationException(String message) {
        super(message);
    }
    
    public JobApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
