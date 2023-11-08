package com.auctionall.userservices.infrastructure.adapter.in.rest.resource;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.domain.shared.Status;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(UUID id, String name, LocalDate dateOfBirth, Status status) {

    public static UserResponse fromDomain(User user) {
        return new UserResponse(user.id(), user.name(), user.dateOfBirth(), user.status());
    }

}
