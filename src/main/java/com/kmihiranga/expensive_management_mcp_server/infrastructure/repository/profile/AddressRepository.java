package com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
}
