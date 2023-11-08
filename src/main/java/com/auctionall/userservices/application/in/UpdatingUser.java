package com.auctionall.userservices.application.in;

import com.auctionall.userservices.application.domain.User;

import java.util.UUID;

public interface UpdatingUser {
    User updateUser(UUID id, User user);
}

