package ch.zuehlke.lambda.facilitator;

import ch.zuehlke.lambda.facilitator.service.HealthService;
import ch.zuehlke.lambda.facilitator.service.HealthServiceMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FacilitatorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void HealthService_getHealth_whenHealthEndpointCalled_ReturnsUp() {
        HealthService healthService = new HealthServiceMock();

        String result = healthService.getHealth();

        assertEquals("UP", result);
    }

}
