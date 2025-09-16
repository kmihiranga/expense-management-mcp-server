package com.kmihiranga.expensive_management_mcp_server.domain.profile.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
