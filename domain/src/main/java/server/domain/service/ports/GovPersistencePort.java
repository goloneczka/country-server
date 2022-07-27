package server.domain.service.ports;

import org.openapitools.model.Institution;
import org.openapitools.model.Institutions;

public interface GovPersistencePort {

    Institutions getInstitutions(String city);

    Institution getInstitution(Integer id);
}
