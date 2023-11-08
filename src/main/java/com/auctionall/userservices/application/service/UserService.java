package com.auctionall.userservices.application.service;

import com.auctionall.userservices.application.architecture.UseCase;
import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.in.FindUser;
import com.auctionall.userservices.application.in.RegisteringUser;
import com.auctionall.userservices.application.in.UpdatingUser;
import com.auctionall.userservices.application.out.UserNotFound;
import com.auctionall.userservices.application.out.Users;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@UseCase
public class UserService implements RegisteringUser, UpdatingUser, FindUser {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    @Override
    public User saveUser(User user) {
        return users.save(user);
    }

    @Override
    public User updateUser(UUID userId, User user) {
        User userPersisted = users.findUserById(userId);

        if(Objects.isNull(userPersisted)){
            throw new UserNotFound();
        }

        return users.save(buildUser(userId, user));
    }

    @Override
    public User findUserById(UUID userId) {
        return null;
    }

    private User buildUser(UUID userId, User user){
        return new User(userId, user.name(), user.dateOfBirth(), user.status());
    }
}
