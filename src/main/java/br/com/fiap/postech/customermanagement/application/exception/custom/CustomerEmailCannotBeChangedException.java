package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;

public class CustomerEmailCannotBeChangedException extends RuntimeException implements ApiErrorResponse {

    public CustomerEmailCannotBeChangedException() {
        super("Customer email cannot be CHANGED!");
    }

    @Override
    public String getType() {
        return ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.getTitle();
    }

    @Override
    public int getStatus() {
        return 409;
    }
}
