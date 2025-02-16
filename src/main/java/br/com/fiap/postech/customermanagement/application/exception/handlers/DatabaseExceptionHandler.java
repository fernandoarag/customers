package br.com.fiap.postech.customermanagement.application.exception.handlers;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponseImpl;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import br.com.fiap.postech.customermanagement.application.exception.custom.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DatabaseExceptionHandler {

    public ApiErrorResponseImpl handleCustomerNotFoundException(CustomerNotFoundException e) {
        return new ApiErrorResponseImpl(
                ErrorType.NOT_FOUND.name(),
                ErrorType.NOT_FOUND.getTitle(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerAlreadyExistsException(CustomerAlreadyExistsException e) {
        return new ApiErrorResponseImpl(
                ErrorType.EMAIL_CANNOT_BE_CHANGED.name(),
                ErrorType.EMAIL_CANNOT_BE_CHANGED.getTitle(),
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerEmailCannotBeBlankException(CustomerEmailCannotBeBlankException e) {
        return new ApiErrorResponseImpl(
                ErrorType.INVALID_JSON.name(),
                ErrorType.INVALID_JSON.getTitle(),
                HttpStatus.NOT_ACCEPTABLE.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerEmailCannotBeChangedException(CustomerEmailCannotBeChangedException e) {
        return new ApiErrorResponseImpl(
                ErrorType.EMAIL_CANNOT_BE_CHANGED.name(),
                ErrorType.EMAIL_CANNOT_BE_CHANGED.getTitle(),
                HttpStatus.CONFLICT.value(),
                e.getMessage()
        );
    }

    public ApiErrorResponseImpl handleCustomerEmailInvalidException(CustomerEmailInvalidException e) {
        return new ApiErrorResponseImpl(
                ErrorType.INVALID_JSON.name(),
                ErrorType.INVALID_JSON.getTitle(),
                HttpStatus.NOT_ACCEPTABLE.value(),
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
