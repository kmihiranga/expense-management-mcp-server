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
public class Profile extends DomainEntity {

    @Id
    private String id;

    @ToolParam(description = "User's first name")
    private String firstName;

    @ToolParam(description = "User's last name")
    private String lastName;

    @ToolParam(description = "User's id")
    private String userId;

    @ToolParam(description = "User's age")
    private String age;

    @ToolParam(description = "User's gender")
    private String gender;
}
