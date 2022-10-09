package server.infrastructure.restTemplate;

import org.openapitools.model.Institution;
import org.openapitools.model.Institutions;
import org.springframework.web.client.RestTemplate;
import server.domain.service.ports.GovPersistencePort;

import java.text.MessageFormat;

class GovPersistenceAdapter implements GovPersistencePort {

    private final RestTemplate restTemplateBean;

    public GovPersistenceAdapter(RestTemplate restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }

    @Override
    public Institutions getInstitutions(String city) {
        return restTemplateBean.getForEntity("/institutions/?city={city}", Institutions.class, city)
                .getBody();
    }

    @Override
    public Institution getInstitution(Integer id) {
        return restTemplateBean.getForEntity(
                    MessageFormat.format("/institutions/{0}", id), Institution.class)
                .getBody();
    }
}
