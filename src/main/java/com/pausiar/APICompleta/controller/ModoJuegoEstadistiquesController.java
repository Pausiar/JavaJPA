package com.pausiar.APICompleta.controller;

import com.pausiar.APICompleta.models.DTO.ModoJuegoEstadistiquesResponse;
import com.pausiar.APICompleta.service.ModoJuegoEstadistiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modosjuego")
public class ModoJuegoEstadistiquesController {

    @Autowired
    private ModoJuegoEstadistiquesService modoJuegoEstadistiquesService;

    @GetMapping("/{id}/estadistiques")
    public ModoJuegoEstadistiquesResponse obtindreEstadistiques(@PathVariable Long id) {
        return modoJuegoEstadistiquesService.obtindreEstadistiques(id);
    }
}

