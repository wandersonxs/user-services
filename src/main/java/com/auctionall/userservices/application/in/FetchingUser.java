package com.auctionall.userservices.application.in;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.infrastructure.reactive.UnitReactive;

public interface FetchingUser {
    UnitReactive<User> findUserById(Integer id);
    UnitReactive<Boolean> existsUserById(Integer id);
}

