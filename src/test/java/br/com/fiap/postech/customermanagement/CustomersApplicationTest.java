package br.com.fiap.postech.customermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CustomersApplication.class)
@ActiveProfiles("test")
class CustomersApplicationTest {

    @Test
    void main_runsSpringApplication() {
        assertDoesNotThrow(() -> CustomersApplication.main(new String[]{}));
    }
}