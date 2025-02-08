package br.com.fiap.postech.customers.domain;


import lombok.Data;

@Data
public class Customers {

    public Customers(Long id, String name, String email, String phone, String cell_phone, String zip_code, String address, String address_number, String neighborhood, String city, String state, String complement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cell_phone;
        this.zipCode = zip_code;
        this.address = address;
        this.addressNumber = address_number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    private Long id; // Identificador único no banco de dados
    private String name; // Nome do cliente
    private String email;  // Email do cliente
    private String phone; // Telefone do cliente
    private String cellPhone; // Telefone do cliente
    private String zipCode; // Código da residência
    private String address; // Rua da residência
    private String addressNumber; // Número da residência
    private String neighborhood; // Bairro da residência
    private String city; // Cidade de residência
    private String state; // Estado de residência
    private String complement; // Complemento da residência

}
