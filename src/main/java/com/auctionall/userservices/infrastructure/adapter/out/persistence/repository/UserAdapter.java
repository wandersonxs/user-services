package com.auctionall.userservices.infrastructure.adapter.out.persistence.repository;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.out.UserNotFound;
import com.auctionall.userservices.application.out.Users;
import com.auctionall.userservices.infrastructure.adapter.out.persistence.entity.UserEntity;
import com.auctionall.userservices.infrastructure.reactive.UnitReactive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserAdapter implements Users {

    private final UserRepository userRepository;

    @Override
    public UnitReactive<User> findUserById(Integer userId) throws UserNotFound {
        Mono<UserEntity> byId = userRepository.findById(userId);
        return UnitReactive.of(byId).map(UserEntity::toDomain);
    }

    @Override
    public UnitReactive<User> save(User user) {
        Mono<User> userMono = userRepository.save(UserEntity.fromDomain(user)).map(UserEntity::toDomain);
        return UnitReactive.of(userMono);
    }

    @Override
    public UnitReactive<Boolean> existsUserById(Integer userId) {
        Mono<Boolean> booleanMono = userRepository.existsById(userId);
        return UnitReactive.of(booleanMono);
    }

    @Override
    public UnitReactive<Boolean> existsUserByName(User user) {
        Mono<Boolean> booleanMono = userRepository.findByName(user.name()).hasElements();
        return UnitReactive.of(booleanMono);
    }
}
