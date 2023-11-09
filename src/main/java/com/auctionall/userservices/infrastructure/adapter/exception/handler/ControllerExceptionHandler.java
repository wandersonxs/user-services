package com.auctionall.userservices.infrastructure.adapter.exception.handler;

import com.auctionall.userservices.application.out.UserNotFound;
import com.auctionall.userservices.infrastructure.adapter.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ExceptionDetails> notFoundHandler(UserNotFound ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .code(Integer.toString(400))
                .message(Objects.isNull(ex.getMessage()) ? "Not Found" : ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

}




