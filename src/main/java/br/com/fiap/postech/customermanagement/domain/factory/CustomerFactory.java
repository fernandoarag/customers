package br.com.fiap.postech.customermanagement.domain.factory;


import br.com.fiap.postech.customermanagement.domain.model.Customer;

/**
 * Factory interface for creating Customer objects.
 */
public interface CustomerFactory {

    /**
     * Creates a new Customer with the specified details.
     *
     * @param id            the unique identifier of the customer
     * @param name          the name of the customer
     * @param email         the email address of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     * @return a new Customer object
     */
    Customer create(Long id, String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement);

    /**
     * Creates a new Customer without an ID.
     *
     * @param name          the name of the customer
     * @param email         the email address of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     * @return a new Customer object
     */
    Customer create(String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement);

}
