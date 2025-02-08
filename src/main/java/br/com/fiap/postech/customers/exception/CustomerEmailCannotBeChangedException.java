package br.com.fiap.postech.customers.exception;

public class CustomerEmailCannotBeChangedException extends RuntimeException {

    public CustomerEmailCannotBeChangedException() {
        super("Customer email cannot be CHANGED!");
    }
}
