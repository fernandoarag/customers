package br.com.fiap.postech.customermanagement.infrastructure.config;

import br.com.fiap.postech.customermanagement.application.factory.CustomerFactoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerConfigTest {

    @Test
    void customerFactoryBeanIsNotNull() {
        CustomerConfig customerConfig = new CustomerConfig();
        assertNotNull(customerConfig.customerFactory());
    }

    @Test
    void customerFactoryBeanReturnsCorrectType() {
        CustomerConfig customerConfig = new CustomerConfig();
        assertTrue(customerConfig.customerFactory() instanceof CustomerFactoryImpl);
    }

}