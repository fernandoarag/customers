package br.com.fiap.postech.customermanagement.domain.factory;


import br.com.fiap.postech.customermanagement.domain.model.Customer;

public interface CustomerFactory {

    Customer create(Long id, String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement);
    Customer create(String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement);

}
