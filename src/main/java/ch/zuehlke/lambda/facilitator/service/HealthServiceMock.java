package ch.zuehlke.lambda.facilitator.service;

import org.springframework.stereotype.Service;

@Service
public class HealthServiceMock implements HealthService {
    @Override
    public String getHealth() {
        return "UP";
    }
}
