package br.com.fiap.postech.customermanagement.application.exception.handlers;

import br.com.fiap.postech.customermanagement.application.exception.ApiErrorResponseImpl;
import br.com.fiap.postech.customermanagement.application.exception.ErrorType;
import br.com.fiap.postech.customermanagement.application.exception.custom.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterfaceExceptionHandlerTest {

    private InterfaceExceptionHandler interfaceExceptionHandler;

    @BeforeEach
    void setUp() {
        interfaceExceptionHandler = new InterfaceExceptionHandler();
    }

    @Test
    void shouldHandleInvalidInputException() {
        InvalidInputException exception = new InvalidInputException("Invalid input provided");
        ApiErrorResponseImpl response = interfaceExceptionHandler.handleInvalidInputException(exception);
        assertEquals(ErrorType.INVALID_INPUT.name(), response.getType());
        assertEquals(ErrorType.INVALID_INPUT.getTitle(), response.getTitle());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        assertEquals("Invalid input provided", response.getDetail());
    }

    @Test
    void shouldHandleInvalidInputExceptionWithEmptyMessage() {
        InvalidInputException exception = new InvalidInputException("");
        ApiErrorResponseImpl response = interfaceExceptionHandler.handleInvalidInputException(exception);
        assertEquals(ErrorType.INVALID_INPUT.name(), response.getType());
        assertEquals(ErrorType.INVALID_INPUT.getTitle(), response.getTitle());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        assertEquals("", response.getDetail());
    }

    @Test
    void shouldHandleInvalidInputExceptionWithNullMessage() {
        InvalidInputException exception = new InvalidInputException(null);
        ApiErrorResponseImpl response = interfaceExceptionHandler.handleInvalidInputException(exception);
        assertEquals(ErrorType.INVALID_INPUT.name(), response.getType());
        assertEquals(ErrorType.INVALID_INPUT.getTitle(), response.getTitle());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        assertEquals(null, response.getDetail());
    }
}