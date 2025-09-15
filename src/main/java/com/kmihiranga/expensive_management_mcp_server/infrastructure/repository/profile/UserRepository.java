package com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByDeleted(boolean deleted);
}
