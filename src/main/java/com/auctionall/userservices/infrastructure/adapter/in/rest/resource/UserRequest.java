package com.auctionall.userservices.infrastructure.adapter.in.rest.resource;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.domain.shared.Status;

import java.time.LocalDate;
import java.util.UUID;

public record UserRequest(UUID id, String name, LocalDate dateOfBirth, Status status) {

     public User toDomain() {
        return new User(id, name, dateOfBirth, status);
    }

}
