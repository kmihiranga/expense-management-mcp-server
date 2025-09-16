package com.kmihiranga.expensive_management_mcp_server.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DomainEntity {

    private Date createdDate = new Date();

    private Date updatedDate = new Date();

    private boolean deleted = false;
}
