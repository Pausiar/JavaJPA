package com.pausiar.APICompleta.service;

import com.pausiar.APICompleta.models.DTO.ModoJuegoEstadistiquesResponse;
import com.pausiar.APICompleta.models.Entitats.Mapa;
import com.pausiar.APICompleta.models.Entitats.ModoJuego;
import com.pausiar.APICompleta.models.Repositoris.ModoJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModoJuegoEstadistiquesService {

    @Autowired
    private ModoJuegoRepository modoJuegoRepository;

    public ModoJuegoEstadistiquesResponse obtindreEstadistiques(Long modoId) {

        // 1) Buscar el modo de joc
        ModoJuego modoJuego = modoJuegoRepository.findById(modoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modo de joc no trobat"));

        // 2) Recuperar els mapes
        List<Mapa> mapes = modoJuego.getMapes();

        // Si el modo no té mapes: error 404
        if (mapes == null || mapes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El modo de joc no té mapes");
        }

        // 3) Calcular estadístiques
        int numMapes = mapes.size();
        List<String> nomsMapes = new ArrayList<>();

        // 4) Recorregut
        for (Mapa mapa : mapes) {
            nomsMapes.add(mapa.getNom());
        }

        // 5) Retornar el DTO
        return new ModoJuegoEstadistiquesResponse(
                modoJuego.getNom(),
                modoJuego.getDescripcio(),
                numMapes,
                nomsMapes
        );
    }
}

