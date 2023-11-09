package com.auctionall.userservices.infrastructure.adapter.out.persistence.repository;

import com.auctionall.userservices.infrastructure.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
    Flux<UserEntity> findByName(String name);
}
