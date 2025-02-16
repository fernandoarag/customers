package br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFilter {

    private Long id; // Identificador único no banco de dados
    private String name; // Nome do cliente
    private String email;  // Email do cliente
    private String phone; // Telefone do cliente
    private String cellPhone; // Telefone do cliente
    private String zipCode; // Código da residência
    private String neighborhood; // Bairro da residência
    private String city; // Cidade de residência
    private String state; // Estado de residência

}
