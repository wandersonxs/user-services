package com.auctionall.userservices.infrastructure.adapter.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String code;
    protected String message;
    protected LocalDateTime timestamp;
}
