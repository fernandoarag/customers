package br.com.fiap.postech.customers.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final String type, final String typeValue) {
        super("Customer with " + type + ": " + typeValue + " not found!");
    }
}
