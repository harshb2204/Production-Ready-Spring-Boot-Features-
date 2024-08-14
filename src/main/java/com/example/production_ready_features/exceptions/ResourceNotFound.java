package com.example.production_ready_features.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String message){
        super(message);
    }
}
