package server.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.domain.service.ports.LocationServicePort;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    LocationServicePort locationServicePort;

    public LocationController(LocationServicePort locationServicePort) {
        this.locationServicePort = locationServicePort;
    }


}
