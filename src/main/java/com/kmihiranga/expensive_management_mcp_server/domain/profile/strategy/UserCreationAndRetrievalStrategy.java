package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;

public interface UserCreationAndRetrievalStrategy {

    User createUser(User user);
}
