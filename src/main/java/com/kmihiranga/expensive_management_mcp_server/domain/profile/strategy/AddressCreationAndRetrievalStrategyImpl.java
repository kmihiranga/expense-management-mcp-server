package com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy;

import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.exception.AddressNotFoundException;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressCreationAndRetrievalStrategyImpl implements AddressCreationAndRetrievalStrategy{

    private final AddressRepository addressRepository;

    @Override
    public void createAddress(Address address) {

        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Address address) {

        log.info("Started deleting address with ID: {}", address.getId());

        address.setDeleted(true);
        addressRepository.save(address);

        log.info("Finished deleting address with ID: {}", address.getId());
    }

    @Override
    public Address getAddressByUserId(String userId) {

        log.info("Started retrieving address for user ID: {}", userId);

        Address address = addressRepository.findByUserIdAndDeleted(userId, false);

        if (address == null) {

            log.error("No address found for user ID: {}", userId);

            throw new AddressNotFoundException("No address found for user ID: " + userId);
        }

        return address;
    }
}
