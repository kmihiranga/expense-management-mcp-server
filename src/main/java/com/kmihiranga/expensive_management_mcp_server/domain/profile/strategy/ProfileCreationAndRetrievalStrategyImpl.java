package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileCreationAndRetrievalStrategyImpl implements ProfileCreationAndRetrievalStrategy{

    private final ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {

        return profileRepository.save(profile);
    }
}
