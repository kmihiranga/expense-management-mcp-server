package com.kmihiranga.expensive_management_mcp_server.domain.profile;

import com.kmihiranga.expensive_management_mcp_server.domain.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ex_addresses")
@Getter
@Setter
@Builder
public class Address extends DomainEntity {

    @Id
    private String id;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private String userId;
}
