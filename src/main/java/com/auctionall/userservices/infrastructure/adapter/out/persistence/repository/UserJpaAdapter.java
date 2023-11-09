package com.auctionall.userservices.infrastructure.adapter.out.persistence.repository;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.out.UserNotFound;
import com.auctionall.userservices.application.out.Users;
import com.auctionall.userservices.infrastructure.adapter.out.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements Users {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findUserById(UUID userId) throws UserNotFound {
        return userJpaRepository.findById(userId)
                .map(UserEntity::toDomain)
                .orElseThrow(UserNotFound::new);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.fromDomain(user)).toDomain();
    }
}
