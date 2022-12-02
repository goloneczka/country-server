package server.domain.service;

import server.domain.service.dto.Location;
import server.domain.service.ports.LocationPersistencePort;
import server.domain.service.ports.LocationServicePort;

import java.util.List;

public class LocationServiceImpl implements LocationServicePort {

    private final LocationPersistencePort locationPersistencePort;

    public LocationServiceImpl(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public Location getLocation(Long id) {
        return locationPersistencePort.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationPersistencePort.getAll();
    }

    @Override
    public Long createLocation(Location location) {
        return locationPersistencePort.create(location);
    }


}
