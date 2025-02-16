package br.com.fiap.postech.customermanagement.application.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
    DATABASE_INTEGRITY("Database Integrity Error"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    INVALID_JSON("Invalid Request Body"),
    INVALID_INPUT("Invalid Input"),
    ALREADY_EXISTS("Customer Already Exists"),
    EMAIL_CANNOT_BE_CHANGED("Email Cannot Be Changed"),
    NOT_FOUND("Customer Not Found");

    private final String title;

    ErrorType(String title) {
        this.title = title;
    }
}
