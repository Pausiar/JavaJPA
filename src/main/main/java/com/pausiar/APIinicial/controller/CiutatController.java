package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.Ciutat;
import com.pausiar.APIinicial.model.CiutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ciutats")
public class CiutatController {

    @Autowired
    private CiutatRepository ciutatRepository;

    @GetMapping
    public List<Ciutat> obtenirCiutats() {
        List<Ciutat> ciutats = (List<Ciutat>) ciutatRepository.findAll();
        List<Ciutat> resultat = new ArrayList<>();

        for (Ciutat ciutat : ciutats) {
            resultat.add(ciutat);
        }

        return resultat;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciutat> obtenirCiutatPerId(@PathVariable Long id) {
        return ciutatRepository.findById(id)
                .map(ciutat -> ResponseEntity.ok().body(ciutat))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ciutat> crearCiutat(@RequestBody Ciutat ciutat) {
        Ciutat novaCiutat = ciutatRepository.save(ciutat);
        return ResponseEntity.created(URI.create("/ciutats/" + novaCiutat.getId())).body(novaCiutat);
    }

}
