package br.com.fiap.postech.customermanagement.interfaces.dtos;

public record CustomerResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String cellPhone,
        String zipCode,
        String address,
        String addressNumber,
        String neighborhood,
        String city,
        String state,
        String complement
) {
}
