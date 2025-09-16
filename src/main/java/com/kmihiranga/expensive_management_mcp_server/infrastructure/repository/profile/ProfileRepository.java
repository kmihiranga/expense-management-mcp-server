package com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

    Profile findByUserIdAndDeleted(String userId, boolean deleted);
}
