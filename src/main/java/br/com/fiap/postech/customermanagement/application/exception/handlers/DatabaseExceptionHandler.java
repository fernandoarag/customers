package br.com.fiap.postech.customermanagement.application.exception.handlers;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponseImpl;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeChangedException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DatabaseExceptionHandler {

    public ApiErrorResponseImpl handleCustomerNotFoundException(CustomerNotFoundException e) {
        return new ApiErrorResponseImpl(
                ErrorType.CUSTOMER_NOT_FOUND.name(),
                ErrorType.CUSTOMER_NOT_FOUND.getTitle(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerAlreadyExistsException(CustomerAlreadyExistsException e) {
        return new ApiErrorResponseImpl(
                ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.name(),
                ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.getTitle(),
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerEmailCannotBeChangedException(CustomerEmailCannotBeChangedException e) {
        return new ApiErrorResponseImpl(
                ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.name(),
                ErrorType.CUSTOMER_EMAIL_CANNOT_BE_CHANGED.getTitle(),
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleDatabaseIntegrityViolation(DataIntegrityViolationException e) {
        return new ApiErrorResponseImpl(
                ErrorType.INTERNAL_SERVER_ERROR.name(),
                ErrorType.INTERNAL_SERVER_ERROR.getTitle(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
    }
}
