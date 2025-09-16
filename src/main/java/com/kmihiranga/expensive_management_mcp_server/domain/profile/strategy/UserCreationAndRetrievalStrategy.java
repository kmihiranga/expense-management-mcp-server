package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;

import java.util.List;

public interface UserCreationAndRetrievalStrategy {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    void deleteUser(User user);
}
