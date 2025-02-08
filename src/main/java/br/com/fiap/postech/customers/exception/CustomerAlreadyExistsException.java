package br.com.fiap.postech.customers.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(final String email) {
        super("Customer with EMAIL: " + email + " already exists!");
    }
}
