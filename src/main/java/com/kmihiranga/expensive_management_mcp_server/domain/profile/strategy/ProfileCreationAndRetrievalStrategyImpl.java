package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.ProfileNotFoundException;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileCreationAndRetrievalStrategyImpl implements ProfileCreationAndRetrievalStrategy{

    private final ProfileRepository profileRepository;

    @Override
    public void createProfile(Profile profile) {

        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {

        log.info("Started deleting profile with ID: {}", profile.getId());

        profile.setDeleted(true);
        profileRepository.save(profile);

        log.info("Finished deleting profile with ID: {}", profile.getId());
    }

    @Override
    public Profile getProfileByUserId(String userId) {

        log.info("Started retrieving profile for user ID: {}", userId);

        Profile profile = profileRepository.findByUserIdAndDeleted(userId, false);

        if (profile == null) {

            log.error("No profile found for user ID: {}", userId);

            throw new ProfileNotFoundException("No profile found for user ID: " + userId);
        }

        return profile;
    }
}
