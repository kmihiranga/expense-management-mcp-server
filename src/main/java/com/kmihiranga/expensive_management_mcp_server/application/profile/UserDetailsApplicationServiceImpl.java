package com.kmihiranga.expensive_management_mcp_server.application.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;
import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.CreateUserRQ;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Address;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.Profile;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.User;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.AddressCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.ProfileCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.UserCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.UserProfileDetailCreationAndRetrievalStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsApplicationServiceImpl implements UserDetailsApplicationService {

    private final UserCreationAndRetrievalStrategy userCreationAndRetrievalStrategy;

    private final AddressCreationAndRetrievalStrategy addressCreationAndRetrievalStrategy;

    private final ProfileCreationAndRetrievalStrategy profileCreationAndRetrievalStrategy;

    private final UserProfileDetailCreationAndRetrievalStrategy userProfileDetailCreationAndRetrievalStrategy;

    @Override
    @Tool(name = "createUser",
            description = "Create a new user with the provided details with profile and address details.")
    public User createUser(@ToolParam CreateUserRQ createUserRQ) {

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

    @Override
    @Tool(name = "getAllUsers", description = "Retrieve all users except deleted users.")
    public List<UserDetailDTO> getAllUsers() {

        log.info("Started retrieving all users list.");

        // retrieve all users
        return userProfileDetailCreationAndRetrievalStrategy.retrieveUserDetails();
    }

    @Override
    @Tool(name = "getUserByEmail", description = "Retrieve user details for the provided email.")
    public UserDetailDTO getUserByEmail(String email) {

        log.info("Started retrieving user details for email: {}", email);

        UserDetailDTO userDetail = userProfileDetailCreationAndRetrievalStrategy.retrieveUserDetailByEmail(email);

        log.info("Finished retrieving user details for email: {}", email);

        return userDetail;
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
                .firstName(createUserRQ.getFirstName())
                .lastName(createUserRQ.getLastName())
                .age(createUserRQ.getAge())
                .gender(createUserRQ.getGender())
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
                .addressLine1(createUserRQ.getAddressLine1())
                .addressLine2(createUserRQ.getAddressLine2())
                .city(createUserRQ.getCity())
                .state(createUserRQ.getState())
                .zipCode(createUserRQ.getZipCode())
                .country(createUserRQ.getCountry())
                .userId(user.getId())
                .build();
    }
}
