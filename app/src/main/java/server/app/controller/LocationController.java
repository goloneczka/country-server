package server.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.domain.service.dto.Location;
import server.domain.service.ports.LocationServicePort;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    LocationServicePort locationServicePort;

    public LocationController(LocationServicePort locationServicePort) {
        this.locationServicePort = locationServicePort;
    }

    @PostMapping(value = "")
    ResponseEntity<Long> createLocation(@RequestBody Location location){
        return ResponseEntity.ok()
                .body(locationServicePort.createLocation(location));
    }

    @GetMapping(value = "/{locationId}")
    ResponseEntity<Location> getLocation(@PathVariable Long locationId){
        return ResponseEntity.ok()
                .body(locationServicePort.getLocation(locationId));
    }

    @GetMapping(value = "")
    ResponseEntity<List<Location>> getLocations(){
        return ResponseEntity.ok()
                .body(locationServicePort.getAllLocations());
    }


}
