package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.UserNotFoundException;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCreationAndRetrievalStrategyImpl implements UserCreationAndRetrievalStrategy {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = userRepository.findByDeleted(false);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found");
        }

        return users;
    }
}
