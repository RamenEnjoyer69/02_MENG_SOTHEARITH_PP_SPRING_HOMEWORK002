package com.ramenenjoyer69.homework002.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private String message;
    private T payload;
    private int status;
    private Instant timestamp = Instant.now();
}
