package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.UserNotFoundException;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.UserProfileDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileDetailCreationAndRetrievalStrategyImpl implements UserProfileDetailCreationAndRetrievalStrategy {

    private final UserProfileDetailRepository userProfileDetailRepository;

    @Override
    public List<UserDetailDTO> retrieveUserDetails() {

        log.info("Started retrieving user details.");

        List<UserDetailDTO> userDetails = userProfileDetailRepository.retrieveUserDetails();

        if (userDetails.isEmpty()) {

            log.error("No user details found.");

            throw new UserNotFoundException("No user details found");
        }

        log.info("Finished retrieving user details.");

        return userDetails;
    }

    @Override
    public UserDetailDTO retrieveUserDetailByEmail(String email) {

        log.info("Started retrieving user detail for email: {}", email);

        UserDetailDTO userDetail = userProfileDetailRepository.retrieveUserDetailByEmail(email);

        if (userDetail == null) {

            log.error("No user detail found for email: {}", email);

            throw new UserNotFoundException("No user detail found for email: " + email);
        }

        return userDetail;
    }
}
