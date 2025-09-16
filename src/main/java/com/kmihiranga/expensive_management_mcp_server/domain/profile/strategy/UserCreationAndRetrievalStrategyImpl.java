package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.UserAlreadyExistsException;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.UserNotFoundException;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserCreationAndRetrievalStrategyImpl implements UserCreationAndRetrievalStrategy {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        // check if email already exists
        User userByEmail = userRepository.findByEmailAndDeleted(user.getEmail(), false);

        if (userByEmail != null) {

            log.error("User with email {} already exists", user.getEmail());

            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }

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
