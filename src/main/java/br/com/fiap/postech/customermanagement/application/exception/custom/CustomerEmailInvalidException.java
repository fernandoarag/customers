package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

public class CustomerEmailInvalidException extends RuntimeException implements ApiErrorResponse {

    public CustomerEmailInvalidException() {
        super("Customer email is invalid!");
    }

    @Override
    public String getType() {
        return ErrorType.INVALID_JSON.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.INVALID_JSON.getTitle();
    }

    @Override
    public int getStatus() {
        return HttpStatus.NOT_ACCEPTABLE.value();
    }
}
