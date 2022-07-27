package server.app.controller;

import org.openapitools.model.Institutions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.domain.service.ports.GovServicePort;


@RestController
@RequestMapping(path = "/institution")
public class GovController {

    private final GovServicePort govService;

    public GovController(GovServicePort govService) {
        this.govService = govService;
    }

    @GetMapping(value = "/get/{city}")
    ResponseEntity<Institutions> getInstitutions(@PathVariable String city){
        return ResponseEntity.ok()
                .body(govService.getInstitutions(city));
    }



}
