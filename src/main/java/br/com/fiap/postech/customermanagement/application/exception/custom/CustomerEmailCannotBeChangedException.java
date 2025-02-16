package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

public class CustomerEmailCannotBeChangedException extends RuntimeException implements ApiErrorResponse {

    public CustomerEmailCannotBeChangedException() {
        super("Customer email cannot be changed!");
    }

    @Override
    public String getType() {
        return ErrorType.EMAIL_CANNOT_BE_CHANGED.name();
    }

    @Override
    public String getTitle() {
        return ErrorType.EMAIL_CANNOT_BE_CHANGED.getTitle();
    }

    @Override
    public int getStatus() {
        return HttpStatus.CONFLICT.value();
    }
}
