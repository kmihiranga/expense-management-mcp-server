package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;

public interface ProfileCreationAndRetrievalStrategy {

    void createProfile(Profile profile);

    void deleteProfile(Profile profile);

    Profile getProfileByUserId(String userId);
}
