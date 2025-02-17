package br.com.fiap.postech.customermanagement.application.exception.custom;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponse;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when there is invalid input provided.
 */
public class InvalidInputException extends RuntimeException implements ApiErrorResponse {

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidInputException(String message) {
        super(message);
    }

    /**
     * Returns the type of error.
     *
     * @return the error type as a string
     */
    @Override
    public String getType() {
        return "invalid_input";
    }

    /**
     * Returns the title of the error.
     *
     * @return the error title as a string
     */
    @Override
    public String getTitle() {
        return "Invalid input";
    }

    /**
     * Returns the HTTP status code for the error.
     *
     * @return the HTTP status code as an integer
     */
    @Override
    public int getStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}