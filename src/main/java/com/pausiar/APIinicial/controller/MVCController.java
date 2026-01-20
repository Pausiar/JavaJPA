package com.pausiar.APIinicial.controller;

import com.pausiar.APIinicial.model.Ciutat;
import com.pausiar.APIinicial.model.CiutatRepository;
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

    @GetMapping("/ciutats")
    public String llistatCiutats(Model model) {

        // Recuperem totes les ciutats de la base de dades
        List<Ciutat> ciutatList = (List<Ciutat>) ciutatRepository.findAll();

        // Afegim la llista al model amb el nom "ciutats"
        model.addAttribute("ciutats", ciutatList);

        // Retornem el nom de la plantilla Thymeleaf (LlistatCiutats.html)
        return "LlistatCiutats";
    }
}
