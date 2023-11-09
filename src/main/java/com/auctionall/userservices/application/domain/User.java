package com.auctionall.userservices.application.domain;

import com.auctionall.userservices.application.domain.shared.Status;

import java.time.LocalDate;

public record User(Integer id, String name, LocalDate dateOfBirth, Status status) { }
