package br.com.fiap.postech.customermanagement.infrastructure.config;

import br.com.fiap.postech.customermanagement.application.factory.CustomerFactoryImpl;
import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerFactory customerFactory() {
        return new CustomerFactoryImpl();
    }
}
