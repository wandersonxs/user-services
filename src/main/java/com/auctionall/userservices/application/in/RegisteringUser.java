package com.auctionall.userservices.application.in;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.infrastructure.reactive.UnitReactive;

import java.util.UUID;

public interface RegisteringUser {

    UnitReactive<User> saveUser(User user);

}

