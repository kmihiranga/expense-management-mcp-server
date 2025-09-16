package com.kmihiranga.expensive_management_mcp_server.common;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;

import java.util.Date;

public class ObjectGenerator {

    public static UserDetailDTO generateUserDetailDTO() {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setId(Utils.idGenerator());
        userDetailDTO.setEmail("test123@test.com");
        userDetailDTO.setPhoneNumber("+1-555-0123");
        userDetailDTO.setAge(20);
        userDetailDTO.setFullName("John Doe");
        userDetailDTO.setGender("Male");
        userDetailDTO.setAddressLine1("123 Main Street");
        userDetailDTO.setAddressLine2("Apt 123");
        userDetailDTO.setCity("New York");
        userDetailDTO.setState("NY");
        userDetailDTO.setCountry("USA");
        userDetailDTO.setZipCode("10001");
        userDetailDTO.setCreatedDate(new Date());

        return userDetailDTO;
    }
}
