package com.kmihiranga.expensive_management_mcp_server.infrastructure.repository.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.dto.UserDetailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserProfileDetailRepositoryImpl implements UserProfileDetailRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<UserDetailDTO> retrieveUserDetails() {

        log.info("Started retrieving user details.");

        MatchOperation matchStage = Aggregation.match(Criteria.where("deleted").is(false));

        AggregationOperation joinedUserId = context -> new Document("$addFields",
                new Document("joinedUserId", new Document("$toString", "$_id")));

        LookupOperation lookupProfile = LookupOperation.newLookup().from("ex_profiles")
                .localField("userId")
                .foreignField("joinedUserId")
                .as("profile");

        LookupOperation lookupAddress = LookupOperation.newLookup().from("ex_addresses")
                .localField("userId")
                .foreignField("joinedUserId")
                .as("address");

        UnwindOperation unwindProfile = Aggregation.unwind("profile", true);
        UnwindOperation unwindAddress = Aggregation.unwind("address", true);

        ProjectionOperation projectStage = Aggregation.project()
                .and("_id").as("id")
                .andExpression("concat(profile.firstName, ' ', profile.lastName)").as("fullName")
                .and("phoneNumber").as("phoneNumber")
                .and("profile.age").as("age")
                .and("profile.gender").as("gender")
                .and("email").as("email")
                .and("address.addressLine1").as("addressLine1")
                .and("address.addressLine2").as("addressLine2")
                .and("address.country").as("country")
                .and("address.zipCode").as("zipCode")
                .and("address.state").as("state")
                .and("address.city").as("city")
                .and("createdDate").as("createdDate");

        SortOperation sortStage = Aggregation.sort(Sort.Direction.DESC, "createdDate");

        Aggregation aggregation = Aggregation.newAggregation(
                matchStage,
                joinedUserId,
                lookupProfile,
                lookupAddress,
                unwindProfile,
                unwindAddress,
                projectStage,
                sortStage
        );

        return mongoTemplate.aggregate(aggregation, "ex_users", UserDetailDTO.class).getMappedResults();
    }
}
