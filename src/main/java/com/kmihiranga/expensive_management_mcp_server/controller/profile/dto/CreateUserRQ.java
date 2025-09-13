package com.kmihiranga.expensive_management_mcp_server.controller.profile.dto;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRQ {

    private String email;

    private String username;

    private String phoneNumber;

    private Profile profile;

    private Address address;
}
