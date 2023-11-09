package com.auctionall.userservices.infrastructure.adapter.out.persistence.repository;

import com.auctionall.userservices.infrastructure.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
}
