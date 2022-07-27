package server.domain.service;

import org.openapitools.model.Institution;
import org.openapitools.model.Institutions;
import server.domain.service.ports.GovPersistencePort;
import server.domain.service.ports.GovServicePort;

public class GovServiceImpl implements GovServicePort {

    private final GovPersistencePort govPersistencePort;

    public GovServiceImpl(GovPersistencePort govPersistencePort) {
        this.govPersistencePort = govPersistencePort;
    }

    @Override
    public Institutions getInstitutions(String city) {
        return govPersistencePort.getInstitutions(city);
    }

    @Override
    public Institution getInstitution(Integer id) {
        return govPersistencePort.getInstitution(id);
    }
}
