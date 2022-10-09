package server.domain.service.ports;

import server.domain.service.dto.Location;

import java.util.List;

public interface LocationServicePort {

    Location getLocation(Long id);

    List<Location> getAllLocations();
}
