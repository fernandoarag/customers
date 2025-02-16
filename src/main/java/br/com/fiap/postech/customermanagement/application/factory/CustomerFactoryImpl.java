package br.com.fiap.postech.customermanagement.application.factory;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;

public class CustomerFactoryImpl implements CustomerFactory {

    public Customer create(Long id, String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        return new Customer(id, name, email, phone, cellPhone, zipCode, address, addressNumber, neighborhood, city, state, complement);
    }

    public Customer create(String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        return new Customer(name, email, phone, cellPhone, zipCode, address, addressNumber, neighborhood, city, state, complement);
    }

}
