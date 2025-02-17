package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a customer with the specified email already exists.
 */
public class CustomerAlreadyExistsException extends RuntimeException implements ApiErrorResponse {

    /**
     * Constructs a new CustomerAlreadyExistsException with the specified email.
     *
     * @param email the email address of the customer that already exists
     */
    public CustomerAlreadyExistsException(final String email) {
        super("Customer with email: '" + email + "' already exists!");
    }

    /**
     * Returns the type of error.
     *
     * @return the error type as a string
     */
    @Override
    public String getType() {
        return ErrorType.ALREADY_EXISTS.name();
    }

    /**
     * Returns the title of the error.
     *
     * @return the error title as a string
     */
    @Override
    public String getTitle() {
        return ErrorType.ALREADY_EXISTS.getTitle();
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
