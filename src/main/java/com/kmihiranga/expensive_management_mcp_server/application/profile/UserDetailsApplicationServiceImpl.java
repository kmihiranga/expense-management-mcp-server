package com.kmihiranga.expensive_management_mcp_server.application.profile;

import com.kmihiranga.expensive_management_mcp_server.controller.profile.dto.CreateUserRQ;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.AddressCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.ProfileCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.UserCreationAndRetrievalStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsApplicationServiceImpl implements UserDetailsApplicationService {

    private final UserCreationAndRetrievalStrategy userCreationAndRetrievalStrategy;

    private final AddressCreationAndRetrievalStrategy addressCreationAndRetrievalStrategy;

    private final ProfileCreationAndRetrievalStrategy profileCreationAndRetrievalStrategy;

    @Override
    public User createUser(CreateUserRQ createUserRQ) {

        log.info("Creating user with email: {}", createUserRQ.getEmail());

        // create user details
        User user = constructUserDetails(createUserRQ);

        User savedUser = userCreationAndRetrievalStrategy.createUser(user);

        // create a profile using created user details
        Profile profile = constructProfileDetails(createUserRQ, savedUser);

        profileCreationAndRetrievalStrategy.createProfile(profile);

        // create an address using created user details
        Address address = constructAddressDetails(createUserRQ, savedUser);

        addressCreationAndRetrievalStrategy.createAddress(address);

        log.info("User created with ID: {}", savedUser.getId());

        return savedUser;
    }

    /** Construct user details from the request object.
     *
     * @param createUserRQ The request object containing user details.
     * @return A User object constructed from the request data.
     */
    private User constructUserDetails(CreateUserRQ createUserRQ) {
        return User.builder()
                .username(createUserRQ.getUsername())
                .email(createUserRQ.getEmail())
                .phoneNumber(createUserRQ.getPhoneNumber())
                .build();
    }

    /** Construct profile details from the request object and associated user.
     *
     * @param createUserRQ The request object containing profile details.
     * @param user The associated User object.
     * @return A Profile object constructed from the request data and user ID.
     */
    private Profile constructProfileDetails(CreateUserRQ createUserRQ, User user) {
        return Profile.builder()
                .firstName(createUserRQ.getProfile().getFirstName())
                .lastName(createUserRQ.getProfile().getLastName())
                .age(createUserRQ.getProfile().getAge())
                .gender(createUserRQ.getProfile().getGender())
                .userId(user.getId())
                .build();
    }

    /** Construct address details from the request object and associated user.
     *
     * @param createUserRQ The request object containing address details.
     * @param user The associated User object.
     * @return An Address object constructed from the request data and user ID.
     */
    private Address constructAddressDetails(CreateUserRQ createUserRQ, User user) {
        return Address.builder()
                .addressLine1(createUserRQ.getAddress().getAddressLine1())
                .addressLine2(createUserRQ.getAddress().getAddressLine2())
                .city(createUserRQ.getAddress().getCity())
                .state(createUserRQ.getAddress().getState())
                .zipCode(createUserRQ.getAddress().getZipCode())
                .country(createUserRQ.getAddress().getCountry())
                .userId(user.getId())
                .build();
    }
}
