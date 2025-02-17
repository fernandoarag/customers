package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a customer's email cannot be changed.
 */
public class CustomerEmailCannotBeChangedException extends RuntimeException implements ApiErrorResponse {

    /**
     * Constructs a new CustomerEmailCannotBeChangedException with a default message.
     */
    public CustomerEmailCannotBeChangedException() {
        super("Customer email cannot be changed!");
    }

    /**
     * Returns the type of error.
     *
     * @return the error type as a string
     */
    @Override
    public String getType() {
        return ErrorType.EMAIL_CANNOT_BE_CHANGED.name();
    }

    /**
     * Returns the title of the error.
     *
     * @return the error title as a string
     */
    @Override
    public String getTitle() {
        return ErrorType.EMAIL_CANNOT_BE_CHANGED.getTitle();
    }

    /**
     * Returns the HTTP status code for the error.
     *
     * @return the HTTP status code as an integer
     */
    @Override
    public int getStatus() {
        return HttpStatus.CONFLICT.value();
    }
}