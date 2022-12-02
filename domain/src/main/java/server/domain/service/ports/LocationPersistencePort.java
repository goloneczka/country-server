package server.domain.service.ports;

import server.domain.service.dto.Location;

import java.util.List;

public interface LocationPersistencePort {

    List<Location> getAll();

    Location findById(Long id);

    Long create(Location location);
}
