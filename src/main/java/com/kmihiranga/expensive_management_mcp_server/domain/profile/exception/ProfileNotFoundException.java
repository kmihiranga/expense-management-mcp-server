package com.kmihiranga.expensive_management_mcp_server.domain.profile.exception;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(String message) {
        super(message);
    }
}
