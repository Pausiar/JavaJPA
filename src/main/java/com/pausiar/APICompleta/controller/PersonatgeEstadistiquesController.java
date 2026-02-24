package com.pausiar.APICompleta.controller;

import com.pausiar.APICompleta.models.DTO.PersonatgeEstadistiquesResponse;
import com.pausiar.APICompleta.service.PersonatgeEstadistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personatges")
public class PersonatgeEstadistiquesController {

    @Autowired
    private PersonatgeEstadistiquesService personatgeEstadistiquesService;

    @GetMapping("/{id}/estadistiques")
    public PersonatgeEstadistiquesResponse obtindreEstadistiques(@PathVariable Long id) {
        return personatgeEstadistiquesService.obtindreEstadistiques(id);
    }
}

