package com.auctionall.userservices.application.out;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.infrastructure.reactive.UnitReactive;

public interface Users {
    UnitReactive<User> findUserById(Integer userId) throws UserNotFound;

    UnitReactive<Boolean> existsUserById(Integer userId);

    public UnitReactive<Boolean> existsUserByName(User user);

    UnitReactive<User> save(User user);

}
