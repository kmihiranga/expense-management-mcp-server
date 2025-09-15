package com.kmihiranga.expensive_management_mcp_server.application.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.GetAllUsersDTO;
import com.kmihiranga.expensive_management_mcp_server.controller.profile.dto.CreateUserRQ;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;

import java.util.List;

public interface UserDetailsApplicationService {

    User createUser(CreateUserRQ createUserRQ);

    List<GetAllUsersDTO> getAllUsers();
}
