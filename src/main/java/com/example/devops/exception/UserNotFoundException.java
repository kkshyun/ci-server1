package com.example.devops.exception;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException() {
        super("User does not exist");
    }
}
