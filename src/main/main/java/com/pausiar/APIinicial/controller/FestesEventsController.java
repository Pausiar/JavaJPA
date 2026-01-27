package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.FestesEvents;
import com.pausiar.APIinicial.model.FestersEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/festesevents")
public class FestesEventsController {

    @Autowired
    private FestersEventsRepository festesEventsRepository;

    @GetMapping
    public List<FestesEvents> obtenirFestesEvents() {
        List<FestesEvents> festesEvents = (List<FestesEvents>) festesEventsRepository.findAll();
        List<FestesEvents> resultat = new ArrayList<>();

        for (FestesEvents festaEvent : festesEvents) {
            resultat.add(festaEvent);
        }

        return resultat;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FestesEvents> obtenirFestesEventsPerId(@PathVariable Long id) {
        return festesEventsRepository.findById(id)
                .map(festesEvents -> ResponseEntity.ok().body(festesEvents))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FestesEvents> crearFestesEvents(@RequestBody FestesEvents festesEvents) {
        FestesEvents novaFestaEvent = festesEventsRepository.save(festesEvents);
        return ResponseEntity.created(URI.create("/festesevents/" + novaFestaEvent.getId())).body(novaFestaEvent);
    }
}

