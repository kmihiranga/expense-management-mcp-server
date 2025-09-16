package com.kmihiranga.expensive_management_mcp_server.domain.profile.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
