package com.kmihiranga.expensive_management_mcp_server.domain.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

@Document(collection = "ex_users")
@Getter
@Setter
@Builder
public class User extends DomainEntity {

    @Id
    private String id;

    private String email;

    private String username;

    private String phoneNumber;
}
