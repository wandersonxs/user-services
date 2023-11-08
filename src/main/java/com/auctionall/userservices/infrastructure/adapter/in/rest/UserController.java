package com.auctionall.userservices.infrastructure.adapter.in.rest;

import com.auctionall.userservices.application.in.FindUser;
import com.auctionall.userservices.application.in.RegisteringUser;
import com.auctionall.userservices.application.in.UpdatingUser;
import com.auctionall.userservices.infrastructure.adapter.in.rest.resource.UserRequest;
import com.auctionall.userservices.infrastructure.adapter.in.rest.resource.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisteringUser registeringUser;
    private final UpdatingUser updatingUser;
    private final FindUser findUser;

    @PostMapping("/users")
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var user = registeringUser.saveUser(request.toDomain());
        var location = uriComponentsBuilder.path("/users/{id}")
                .buildAndExpand(user.id())
                .toUri();
        return ResponseEntity.created(location).body(UserResponse.fromDomain(user));
    }

    @PutMapping("/users/{id}")
    ResponseEntity<UserResponse> updateOrder(@PathVariable UUID id, @RequestBody UserRequest request) {
        var user = updatingUser.updateUser(id, request.toDomain());
        return ResponseEntity.ok(UserResponse.fromDomain(user));
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserResponse> findUserById(@PathVariable UUID userId) {
        var user = findUser.findUserById(userId);
        return ResponseEntity.ok(UserResponse.fromDomain(user));
    }
}
