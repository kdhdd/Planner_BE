package com.example.planner_be.Exception;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException(String message) {
        super(message);
    }

}
