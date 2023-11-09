package com.auctionall.userservices.application.service;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.in.FetchingUser;
import com.auctionall.userservices.application.in.RegisteringUser;
import com.auctionall.userservices.application.in.UpdatingUser;
import com.auctionall.userservices.application.out.Users;
import com.auctionall.userservices.infrastructure.adapter.exception.BusinessException;
import com.auctionall.userservices.infrastructure.annotations.UseCase;
import com.auctionall.userservices.infrastructure.reactive.UnitReactive;

@UseCase
public class UserService implements RegisteringUser, UpdatingUser, FetchingUser {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    @Override
    public UnitReactive<User> saveUser(User user) {
        return users.existsUserByName(user)
                .flatMap(userExists -> userExists ?
                        UnitReactive.error(new BusinessException("User already registered...")) :
                        users.save(user));
    }

    @Override
    public UnitReactive<User> updateUser(Integer userId, User user) {
        return users.existsUserById(userId)
                .flatMap(userExists -> userExists ?
                        users.save(buildUser(userId, user)) :
                        UnitReactive.error(new BusinessException("User missed on the repository.")));
    }

    @Override
    public UnitReactive<User> findUserById(Integer userId) {
        return users.findUserById(userId);
    }

    @Override
    public UnitReactive<Boolean> existsUserById(Integer id) {
        return users.existsUserById(id);
    }

    private User buildUser(Integer userId, User user) {
        return new User(userId, user.name(), user.dateOfBirth(), user.status());
    }
}
