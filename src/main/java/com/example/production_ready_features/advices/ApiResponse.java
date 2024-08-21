package com.example.production_ready_features.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ApiResponse<T> {
    private T data;
    private ApiError error;

    private LocalDateTime timestamp;

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse() {

        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
