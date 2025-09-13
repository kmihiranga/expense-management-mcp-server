package com.kmihiranga.expensive_management_mcp_server.application.profile;

import com.kmihiranga.expensive_management_mcp_server.controller.profile.dto.CreateUserRQ;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import org.springframework.ai.tool.annotation.Tool;

public interface UserDetailsApplicationService {

    @Tool(name = "createUser",
            description = "Create a new user with the provided details with profile and address details. " +
                    "use the CreateUserRQ object to provide the necessary information.")
    User createUser(CreateUserRQ createUserRQ);
}
