package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.Pais;
import com.pausiar.APIinicial.model.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paisos")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public List<Pais> obtenirPaisos() {
        List<Pais> paisos = (List<Pais>) paisRepository.findAll();
        List<Pais> resultat = new ArrayList<>();

        for (Pais pais : paisos) {
            resultat.add(pais);
        }

        return resultat;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> obtenirPaisPerId(@PathVariable Long id) {
        return paisRepository.findById(id)
                .map(pais -> ResponseEntity.ok().body(pais))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pais> crearPais(@RequestBody Pais pais) {
        Pais nouPais = paisRepository.save(pais);
        return ResponseEntity.created(URI.create("/paisos/" + nouPais.getId())).body(nouPais);
    }
}
