package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a customer is not found.
 */
public class CustomerNotFoundException extends RuntimeException implements ApiErrorResponse {

    /**
     * Constructs a new CustomerNotFoundException with the specified type and type value.
     *
     * @param type the type of identifier (e.g., "email", "ID")
     * @param typeValue the value of the identifier
     */
    public CustomerNotFoundException(final String type, final String typeValue) {
        super("Customer with " + type + ": '" + typeValue + "' not found!");
    }

    /**
     * Returns the type of error.
     *
     * @return the error type as a string
     */
    @Override
    public String getType() {
        return ErrorType.NOT_FOUND.name();
    }

    /**
     * Returns the title of the error.
     *
     * @return the error title as a string
     */
    @Override
    public String getTitle() {
        return ErrorType.NOT_FOUND.getTitle();
    }

    /**
     * Returns the HTTP status code for the error.
     *
     * @return the HTTP status code as an integer
     */
    @Override
    public int getStatus() {
        return HttpStatus.NOT_FOUND.value();
    }

}