package com.kmihiranga.expensive_management_mcp_server;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;
import com.kmihiranga.expensive_management_mcp_server.common.ObjectGenerator;
import com.kmihiranga.expensive_management_mcp_server.domain.profile.strategy.UserProfileDetailCreationAndRetrievalStrategy;
import com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile.UserProfileDetailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExpensiveManagementMcpServerApplicationTests {

	@Autowired
	private UserProfileDetailCreationAndRetrievalStrategy userProfileDetailCreationAndRetrievalStrategy;

	@MockitoBean
	private UserProfileDetailRepository userProfileDetailRepository;

	private List<UserDetailDTO> userDetails;

	@BeforeEach
	void beforeEach() {
		userDetails = new ArrayList<>(1);
		UserDetailDTO userDetailDTO = ObjectGenerator.generateUserDetailDTO();

		userDetails.add(userDetailDTO);
	}

	@DisplayName("Test retrieve user profile details")
	@Test
	@Order(1)
	void testRetrieveUserProfileDetails() {

		when(userProfileDetailRepository.retrieveUserDetails())
				.thenReturn(userDetails);

		List<UserDetailDTO> result = userProfileDetailCreationAndRetrievalStrategy.retrieveUserDetails();

		assertEquals(1, result.size());
	}

	@DisplayName("Test retrieve users list")
	@Test
	@Order(2)
	void testRetrieveUsersList() {

		List<UserDetailDTO> usersList = Collections.singletonList(ObjectGenerator.generateUserDetailDTO());

		when(userProfileDetailRepository.retrieveUserDetails()).thenReturn(usersList);

		List<UserDetailDTO> results = userProfileDetailCreationAndRetrievalStrategy.retrieveUserDetails();

		assertEquals(1, results.size());
		assertEquals("John Doe", results.getFirst().getFullName());
		assertEquals("123 Main Street", results.getFirst().getAddressLine1());
	}
}
