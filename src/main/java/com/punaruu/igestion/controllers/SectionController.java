package com.punaruu.igestion.controllers;

import com.punaruu.igestion.domain.entities.Section;
import com.punaruu.igestion.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(allowCredentials = "true")
@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "/api/v1/sections", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Section>> getAll() {
        return new ResponseEntity<>(this.sectionService.listerTous(), HttpStatus.OK);
    }
}
