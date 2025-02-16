package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RuntimeException implements ApiErrorResponse {

    public CustomerNotFoundException(final String type, final String typeValue) {
        super("Customer with " + type + ": '" + typeValue + "' not found!");
    }

    @Override
    public String getType() {
        return ErrorType.NOT_FOUND.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.NOT_FOUND.getTitle();
    }

    @Override
    public int getStatus() {
        return HttpStatus.NOT_FOUND.value();
    }

}
