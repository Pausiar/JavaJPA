package com.pausiar.APIinicial.model;

import jakarta.persistence.*;

@Entity
@Table
public class FestesEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String descripcio;
    private String imatge;

    public FestesEvents() {
    }

    public FestesEvents(String nom, String descripcio, String imatge) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.imatge = imatge;
    }

    // getters i setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }
}

