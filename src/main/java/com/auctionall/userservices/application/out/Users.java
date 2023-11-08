package com.auctionall.userservices.application.out;

import com.auctionall.userservices.application.domain.User;

import java.util.UUID;

public interface Users {
    User findUserById(UUID userId) throws UserNotFound;
    User save(User user);
}
