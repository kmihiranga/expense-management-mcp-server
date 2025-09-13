package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressCreationAndRetrievalStrategyImpl implements AddressCreationAndRetrievalStrategy{

    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {

        return addressRepository.save(address);
    }
}
