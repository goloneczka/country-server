package server.gov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import server.domain.service.ports.GovPersistencePort;
import server.gov.restTemplate.RestTemplateFactory;

@Configuration
@Import(RestTemplateFactory.class)
public class BeanConfig {

    private final RestTemplate restTemplateBean;

    public BeanConfig(RestTemplate restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }

    @Bean
    public GovPersistencePort govPersistence() {
        return new GovPersistenceAdapter(restTemplateBean);
    }


}
