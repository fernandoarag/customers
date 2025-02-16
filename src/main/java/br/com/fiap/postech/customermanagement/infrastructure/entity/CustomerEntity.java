package br.com.fiap.postech.customermanagement.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Customers")
@Table(name = "CUSTOMERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id; // Identificador único no banco de dados
    @Column
    private String name; // Nome do cliente
    @Email
    @Column(nullable = false, unique = true, updatable = false)
    private String email;  // Email do cliente
    @Column
    private String phone; // Telefone do cliente
    @Column
    private String cellPhone; // Telefone do cliente
    @Column
    private String zipCode; // Código da residência
    @Column
    private String address; // Rua da residência
    @Column
    private String addressNumber; // Número da residência
    @Column
    private String neighborhood; // Bairro da residência
    @Column
    private String city; // Cidade de residência
    @Column
    private String state; // Estado de residência
    @Column
    private String complement; // Complemento da residência

}
