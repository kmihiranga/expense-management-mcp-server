package com.kmihiranga.expensive_management_mcp_server.application.profile.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRQ {

    private String email;

    private String username;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String gender;

    private int age;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
