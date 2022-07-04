package com.project.rest.controller;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.project.model.Projekt;
import com.project.service.ProjektService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 7200)
public class ProjektRestController {
    private ProjektService projektService;
    @Autowired
    public ProjektRestController(ProjektService projektService) {
        this.projektService = projektService;
    }

    @GetMapping("/projekty/{projektId}")
    ResponseEntity<Projekt> getProjekt(@PathVariable Integer projektId) {
        return ResponseEntity.of(projektService.getProjekt(projektId));
    }

    @PostMapping(path = "/projekty")
    ResponseEntity<Void> createProjekt(@Valid @RequestBody Projekt projekt) {
        Projekt createdProjekt = projektService.setProjekt(projekt);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{projektId}").buildAndExpand(createdProjekt.getProjektId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/projekty/{projektId}")
    public ResponseEntity<Void> updateProjekt(@Valid @RequestBody Projekt projekt,
                                              @PathVariable Integer projektId) {
        return projektService.getProjekt(projektId)
                .map(p -> {
                    projektService.setProjekt(projekt);
                    return new ResponseEntity<Void>(HttpStatus.OK); // 200 (można też zwracać 204 - No content)
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 - Not found
    }
    @DeleteMapping("/projekty/{projektId}")
    public ResponseEntity<Void> deleteProjekt(@PathVariable Integer projektId) {
        return projektService.getProjekt(projektId).map(p -> {
            projektService.deleteProjekt(projektId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/projekty")
    Page<Projekt> getProjekty(Pageable pageable) {
        return projektService.getProjekty(pageable);
    }

    @GetMapping(value = "/projekty", params="nazwa")
    Page<Projekt> getProjektyByNazwa(@RequestParam String nazwa, Pageable pageable) {
        return projektService.searchByNazwa(nazwa, pageable);
    }
}
