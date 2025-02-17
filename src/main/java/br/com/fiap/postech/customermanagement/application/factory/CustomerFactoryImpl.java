package br.com.fiap.postech.customermanagement.application.factory;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;

/**
 * Implementation of the CustomerFactory interface.
 * Provides methods to create Customer instances.
 */
public class CustomerFactoryImpl implements CustomerFactory {

    /**
     * Creates a new Customer instance with the specified details.
     *
     * @param id            the ID of the customer
     * @param name          the name of the customer
     * @param email         the email of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     * @return a new Customer instance
     */
    public Customer create(Long id, String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        return new Customer(id, name, email, phone, cellPhone, zipCode, address, addressNumber, neighborhood, city, state, complement);
    }

    /**
     * Creates a new Customer instance with the specified details, without an ID.
     *
     * @param name          the name of the customer
     * @param email         the email of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     * @return a new Customer instance
     */
    public Customer create(String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        return new Customer(name, email, phone, cellPhone, zipCode, address, addressNumber, neighborhood, city, state, complement);
    }

}