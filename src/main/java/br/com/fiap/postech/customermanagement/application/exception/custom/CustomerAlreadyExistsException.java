package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

public class CustomerAlreadyExistsException extends RuntimeException implements ApiErrorResponse {

    public CustomerAlreadyExistsException(final String email) {
        super("Customer with email: '" + email + "' already exists!");
    }

    @Override
    public String getType() {
        return ErrorType.ALREADY_EXISTS.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.ALREADY_EXISTS.getTitle();
    }

    @Override
    public int getStatus() {
        return HttpStatus.CONFLICT.value();
    }
}
