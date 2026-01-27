package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.Provincia;
import com.pausiar.APIinicial.model.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/provincies")
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @GetMapping
    public List<Provincia> obtenirProvincies() {
        List<Provincia> provincies = (List<Provincia>) provinciaRepository.findAll();
        List<Provincia> resultat = new ArrayList<>();

        for (Provincia provincia : provincies) {
            resultat.add(provincia);
        }

        return resultat;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> obtenirProvinciaPerId(@PathVariable Long id) {
        return provinciaRepository.findById(id)
                .map(provincia -> ResponseEntity.ok().body(provincia))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Provincia> crearProvincia(@RequestBody Provincia provincia) {
        Provincia novaProvincia = provinciaRepository.save(provincia);
        return ResponseEntity.created(URI.create("/provincies/" + novaProvincia.getId())).body(novaProvincia);
    }

}
