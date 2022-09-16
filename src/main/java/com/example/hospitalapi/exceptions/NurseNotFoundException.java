package com.example.hospitalapi.exceptions;

public class NurseNotFoundException extends RuntimeException {
    public NurseNotFoundException(Integer id) {
        super("Could not find room " + id);
    }
}
