package com.pausiar.APICompleta.service;

import com.pausiar.APICompleta.models.DTO.PersonatgeEstadistiquesResponse;
import com.pausiar.APICompleta.models.Entitats.Habilitat;
import com.pausiar.APICompleta.models.Entitats.Personatge;
import com.pausiar.APICompleta.models.Repositoris.PersonatgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonatgeEstadistiquesService {

    @Autowired
    private PersonatgeRepository personatgeRepository;

    public PersonatgeEstadistiquesResponse obtindreEstadistiques(Long personatgeId) {

        // 1) Buscar el personatge
        Personatge personatge = personatgeRepository.findById(personatgeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personatge no trobat"));

        // 2) Recuperar les habilitats
        List<Habilitat> habilitats = personatge.getHabilitats();

        // Si el personatge no té habilitats: error 404
        if (habilitats == null || habilitats.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El personatge no té habilitats");
        }

        // 3) Calcular estadístiques
        int numHabilitats = habilitats.size();
        List<String> teclesUtilitzades = new ArrayList<>();
        List<String> nomsHabilitats = new ArrayList<>();
        String habilitatUltimate = null;

        // 4) Recorregut i càlcul
        for (Habilitat habilitat : habilitats) {
            nomsHabilitats.add(habilitat.getNom());

            if (habilitat.getTecla() != null) {
                teclesUtilitzades.add(habilitat.getTecla());

                // La ultimate és la tecla X
                if (habilitat.getTecla().equalsIgnoreCase("X")) {
                    habilitatUltimate = habilitat.getNom();
                }
            }
        }

        // 5) Retornar el DTO
        return new PersonatgeEstadistiquesResponse(
                personatge.getNom(),
                personatge.getRol(),
                numHabilitats,
                teclesUtilitzades,
                habilitatUltimate,
                nomsHabilitats
        );
    }
}

