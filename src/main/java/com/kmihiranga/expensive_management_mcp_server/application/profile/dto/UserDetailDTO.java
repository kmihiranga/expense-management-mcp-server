package com.kmihiranga.expensive_management_mcp_server.application.profile.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDetailDTO {

    private String id;

    private String email;

    private String phoneNumber;

    private String fullName;

    private String gender;

    private int age;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private Date createdDate;
}
