package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;

public class CustomerNotFoundException extends RuntimeException implements ApiErrorResponse {

    public CustomerNotFoundException(final String type, final String typeValue) {
        super("Customer with " + type + ": " + typeValue + " not found!");
    }

    @Override
    public String getType() {
        return ErrorType.CUSTOMER_NOT_FOUND.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.CUSTOMER_NOT_FOUND.getTitle();
    }

    @Override
    public int getStatus() {
        return 404;
    }
}
