package server.infrastructure.location;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import server.domain.service.ports.LocationPersistencePort;

@Configuration
@ComponentScan
public class LocationConfiguration {

    @Bean
    LocationPersistencePort locationPersistence(LocationMapper locationMapper, LocationRepository locationRepository) {
        return new LocationPersistanceAdapter(locationRepository, locationMapper);
    }
}
