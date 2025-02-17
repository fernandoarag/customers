package br.com.fiap.postech.customermanagement.application.exception.handlers;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponseImpl;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import br.com.fiap.postech.customermanagement.application.exception.custom.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Handler for interface-related exceptions.
 */
@Component
public class InterfaceExceptionHandler {

    /**
     * Handles InvalidInputException.
     *
     * @param e the exception to handle
     * @return the API error response
     */
    public ApiErrorResponseImpl handleInvalidInputException(InvalidInputException e) {
        return new ApiErrorResponseImpl(
                ErrorType.INVALID_INPUT.name(),
                ErrorType.INVALID_INPUT.getTitle(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
    }

    /**
     * Handles MethodArgumentNotValidException.
     *
     * @param e the exception to handle
     * @return the API error response
     */
    public ApiErrorResponseImpl handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder("Validation failed for: ");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMessage.append(fieldError.getField())
                    .append(" - ")
                    .append(fieldError.getDefaultMessage())
                    .append("; ");
        }
        return new ApiErrorResponseImpl(
                ErrorType.INVALID_INPUT.name(),
                ErrorType.INVALID_INPUT.getTitle(),
                HttpStatus.BAD_REQUEST.value(),
                errorMessage.toString()
        );
    }
}