package com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;

import java.util.List;

public interface UserProfileDetailRepository {

    List<UserDetailDTO> retrieveUserDetails();
}
