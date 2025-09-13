package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;

public interface AddressCreationAndRetrievalStrategy {

    Address createAddress(Address address);
}
