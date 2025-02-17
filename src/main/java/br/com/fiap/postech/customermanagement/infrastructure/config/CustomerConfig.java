package br.com.fiap.postech.customermanagement.infrastructure.config;

import br.com.fiap.postech.customermanagement.application.factory.CustomerFactoryImpl;
import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Customer-related beans.
 */
@Configuration
public class CustomerConfig {

    /**
     * Creates a bean for CustomerFactory.
     *
     * @return a new instance of CustomerFactoryImpl
     */
    @Bean
    public CustomerFactory customerFactory() {
        return new CustomerFactoryImpl();
    }
}