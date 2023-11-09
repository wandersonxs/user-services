package com.auctionall.userservices.infrastructure.adapter.in.rest;

import com.auctionall.userservices.application.in.FetchingUser;
import com.auctionall.userservices.application.in.RegisteringUser;
import com.auctionall.userservices.application.in.UpdatingUser;
import com.auctionall.userservices.infrastructure.adapter.in.rest.resource.UserRequest;
import com.auctionall.userservices.infrastructure.adapter.in.rest.resource.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisteringUser registeringUser;
    private final UpdatingUser updatingUser;
    private final FetchingUser findUser;

    @PostMapping("/users")
    Mono<ResponseEntity<UserResponse>> createUser(@RequestBody @Valid UserRequest request, UriComponentsBuilder uriComponentsBuilder) {
        return this.registeringUser.saveUser(request.toDomain()).toMono()
                .map(n -> ResponseEntity.created(null).body(UserResponse.fromDomain(n)));

    }

    @PutMapping("/users/{id}")
    Mono<ResponseEntity<UserResponse>> updateOrder(@PathVariable Integer id, @Valid @RequestBody UserRequest request) {
        return this.updatingUser.updateUser(id, request.toDomain()).toMono()
                .map(n -> ResponseEntity.ok(UserResponse.fromDomain(n)));
    }

    @GetMapping("/users/{id}")
    Mono<ResponseEntity<UserResponse>> findUserById(@PathVariable Integer id) {
        return this.findUser.findUserById(id).toMono()
                .map(n -> ResponseEntity.ok(UserResponse.fromDomain(n)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
