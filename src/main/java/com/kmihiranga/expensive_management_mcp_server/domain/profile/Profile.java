package com.kmihiranga.expensive_management_mcp_server.domain.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ex_profiles")
@Getter
@Setter
@Builder
public class Profile extends DomainEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String userId;

    private int age;

    private String gender;
}
