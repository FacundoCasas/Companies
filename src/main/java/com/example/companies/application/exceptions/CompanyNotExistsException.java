package com.example.companies.application.exceptions;

public class CompanyNotExistsException extends RuntimeException {
    public CompanyNotExistsException(String message) {
        super(message);
    }
}