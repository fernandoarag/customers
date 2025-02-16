package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;

public class CustomerAlreadyExistsException extends RuntimeException implements ApiErrorResponse {

    public CustomerAlreadyExistsException(final String email) {
        super("Customer with EMAIL: " + email + " already exists!");
    }

    @Override
    public String getType() {
        return ErrorType.CUSTOMER_ALREADY_EXISTS.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.CUSTOMER_ALREADY_EXISTS.getTitle();
    }

    @Override
    public int getStatus() {
        return 409;
    }
}
