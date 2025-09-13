package com.kmihiranga.expensive_management_mcp_server.domain.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class User extends DomainEntity {

    @Id
    private String id;

    @ToolParam(description = "User's email address")
    private String email;

    @ToolParam(description = "User's username")
    private String username;

    @ToolParam(description = "User's phone number")
    private String phoneNumber;
}
