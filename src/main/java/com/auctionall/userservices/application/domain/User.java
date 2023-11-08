package com.auctionall.userservices.application.domain;

import com.auctionall.userservices.application.domain.shared.Status;

import java.time.LocalDate;
import java.util.UUID;

public record User(UUID id, String name, LocalDate dateOfBirth, Status status) { }
