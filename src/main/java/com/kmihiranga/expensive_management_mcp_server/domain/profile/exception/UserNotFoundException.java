package com.kmihiranga.expensive_management_mcp_server.domain.profile.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
