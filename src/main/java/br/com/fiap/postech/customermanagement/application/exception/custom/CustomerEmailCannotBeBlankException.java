package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a customer's email is blank.
 */
public class CustomerEmailCannotBeBlankException extends RuntimeException implements ApiErrorResponse {

    /**
     * Constructs a new CustomerEmailCannotBeBlankException with a default message.
     */
    public CustomerEmailCannotBeBlankException() {
        super("Customer email cannot be blank!");
    }

    /**
     * Returns the type of error.
     *
     * @return the error type as a string
     */
    @Override
    public String getType() {
        return ErrorType.INVALID_JSON.name();
    }

    /**
     * Returns the title of the error.
     *
     * @return the error title as a string
     */
    @Override
    public String getTitle() {
        return ErrorType.INVALID_JSON.getTitle();
    }

    /**
     * Returns the HTTP status code for the error.
     *
     * @return the HTTP status code as an integer
     */
    @Override
    public int getStatus() {
        return HttpStatus.NOT_ACCEPTABLE.value();
    }
}