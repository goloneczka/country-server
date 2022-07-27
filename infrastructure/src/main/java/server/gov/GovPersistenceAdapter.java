package server.gov;

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
        //TODO:
        // change to /institutions/?city=XXX'
        return restTemplateBean.getForEntity("/institutions/?city={city}", Institutions.class, city)
                .getBody();
    }

    @Override
    public Institution getInstitution(Integer id) {
        return null;
    }
}
