package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/llistats")
public class MVCController {

    @Autowired
    private CiutatRepository ciutatRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private FestersEventsRepository festesEventsRepository;

    @GetMapping("/ciutats")
    public String llistatCiutats(Model model) {

        //recuperem ciutats de la db
        List<Ciutat> ciutatList = (List<Ciutat>) ciutatRepository.findAll();

        //afegim llista al model amb el nom "ciutats"
        model.addAttribute("ciutats", ciutatList);

        //retornem el nom de la plantilla
        return "LlistatCiutats";
    }

    @GetMapping("/provincies")
    public String llistatProvincies(Model model) {
        List<Provincia> provinciaList = (List<Provincia>) provinciaRepository.findAll();
        model.addAttribute("provincies", provinciaList);
        return "LlistaProvincies";
    }

    @GetMapping("/paisos")
    public String llistatPaisos(Model model) {
        List<Pais> paisList = (List<Pais>) paisRepository.findAll();
        model.addAttribute("paisos", paisList);
        return "LlistaPaïsos";
    }

    @GetMapping("/festes")
    public String llistatFestes(Model model) {
        List<FestesEvents> festesList = (List<FestesEvents>) festesEventsRepository.findAll();
        model.addAttribute("festes", festesList);
        return "LlistaFestesEvents";
    }
}
