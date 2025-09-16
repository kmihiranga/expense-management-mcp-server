package com.kmihiranga.expensive_management_mcp_server.application.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;
import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.CreateUserRQ;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;

import java.util.List;

public interface UserDetailsApplicationService {

    User createUser(CreateUserRQ createUserRQ);

    List<UserDetailDTO> getAllUsers();
}
