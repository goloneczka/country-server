package server.infrastructure.location;

import server.domain.service.dto.Location;
import server.domain.service.error.MappingError;
import server.domain.service.ports.LocationPersistencePort;

import java.util.Collections;
import java.util.List;


class LocationPersistanceAdapter implements LocationPersistencePort {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationPersistanceAdapter(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public List<Location> getAll(){
        return locationRepository.
                findAll()
                .stream()
                .map(locationMapper::entityToDTO)
                .toList();
    }

    @Override
    public Long create(Location location) {
        return locationRepository.save(
                locationMapper.dtoToEntity(location)
        ).getId();
    }

    public Location findById(Long id){
        return locationMapper.entityToDTO(
                locationRepository.findById(id)
                        .orElseThrow(() -> new MappingError(Collections.singletonList("Location " + id + "is not present")))
        );
    }

}
