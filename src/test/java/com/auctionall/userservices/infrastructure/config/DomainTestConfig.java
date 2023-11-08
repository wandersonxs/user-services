package com.auctionall.userservices.infrastructure.config;

import com.auctionall.userservices.application.out.Users;
import com.auctionall.userservices.application.stub.InMemoryUsers;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(DomainConfig.class)
public class DomainTestConfig {
    @Bean
    Users users() {
        return new InMemoryUsers();
    }

}
