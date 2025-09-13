package com.kmihiranga.expensive_management_mcp_server.domain.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class Address extends DomainEntity {

    @Id
    private String id;

    @ToolParam(description = "User's address line 1")
    private String addressLine1;

    @ToolParam(description = "User's address line 2")
    private String addressLine2;

    @ToolParam(description = "User's city")
    private String city;

    @ToolParam(description = "User's state")
    private String state;

    @ToolParam(description = "User's country")
    private String country;

    @ToolParam(description = "User's zip code")
    private String zipCode;

    @ToolParam(description = "User's id")
    private String userId;
}
