package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;

import java.util.List;

public interface UserProfileDetailCreationAndRetrievalStrategy {

    List<UserDetailDTO> retrieveUserDetails();
}
