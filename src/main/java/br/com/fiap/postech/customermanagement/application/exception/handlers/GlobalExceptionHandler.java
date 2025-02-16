package br.com.fiap.postech.customermanagement.application.exception.handlers;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponseImpl;
import br.com.fiap.postech.customermanagement.application.exception.custom.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final DatabaseExceptionHandler databaseExceptionHandler;
    private final InterfaceExceptionHandler interfaceExceptionHandler;

    public GlobalExceptionHandler(DatabaseExceptionHandler databaseExceptionHandler, InterfaceExceptionHandler interfaceExceptionHandler) {
        this.databaseExceptionHandler = databaseExceptionHandler;
        this.interfaceExceptionHandler = interfaceExceptionHandler;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ApiErrorResponseImpl handleCustomerNotFoundException(CustomerNotFoundException e) {
        return databaseExceptionHandler.handleCustomerNotFoundException(e);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ApiErrorResponseImpl handleCustomerAlreadyExistsException(CustomerAlreadyExistsException e) {
        return databaseExceptionHandler.handleCustomerAlreadyExistsException(e);
    }

    @ExceptionHandler(CustomerEmailCannotBeChangedException.class)
    public ApiErrorResponseImpl handleCustomerEmailCannotBeChangedException(CustomerEmailCannotBeChangedException e) {
        return databaseExceptionHandler.handleCustomerEmailCannotBeChangedException(e);
    }

    @ExceptionHandler(CustomerEmailCannotBeBlankException.class)
    public ApiErrorResponseImpl handleCustomerEmailCannotBeBlankException(CustomerEmailCannotBeBlankException e) {
        return databaseExceptionHandler.handleCustomerEmailCannotBeBlankException(e);
    }

    @ExceptionHandler(CustomerEmailInvalidException.class)
    public ApiErrorResponseImpl handleCustomerEmailInvalidException(CustomerEmailInvalidException e) {
        return databaseExceptionHandler.handleCustomerEmailInvalidException(e);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ApiErrorResponseImpl handleDatabaseException(DataIntegrityViolationException e) {
        return databaseExceptionHandler.handleDatabaseIntegrityViolation(e);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ApiErrorResponseImpl handleInterfaceException(InvalidInputException e) {
        return interfaceExceptionHandler.handleInvalidInputException(e);
    }
}
