package br.com.fiap.postech.customermanagement.application.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
    DATABASE_INTEGRITY("Database Integrity Error"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    INVALID_JSON("Invalid Request Body"),
    INVALID_INPUT("Invalid Input"),
    CUSTOMER_ALREADY_EXISTS("Customer Already Exists"),
    CUSTOMER_EMAIL_CANNOT_BE_CHANGED("Customer Email Cannot Be Changed"),
    CUSTOMER_NOT_FOUND("Customer Not Found");

    private final String title;

    ErrorType(String title) {
        this.title = title;
    }
}
