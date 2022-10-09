package server.infrastructure.restTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import server.domain.service.ports.GovPersistencePort;

@Configuration
@ComponentScan
public class GovConfiguration {

    @Bean
    public GovPersistencePort govPersistence(RestTemplate restTemplate) {
        return new GovPersistenceAdapter(restTemplate);
    }

}
