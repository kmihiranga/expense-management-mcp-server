package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreationAndRetrievalStrategyImpl implements UserCreationAndRetrievalStrategy {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }
}
