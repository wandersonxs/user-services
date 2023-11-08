package com.auctionall.userservices.application.in;

import com.auctionall.userservices.application.domain.User;

import java.util.UUID;

public interface FindUser {
    User findUserById(UUID id);
}

