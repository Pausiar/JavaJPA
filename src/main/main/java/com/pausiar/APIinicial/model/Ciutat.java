package com.pausiar.APIinicial.model;

import jakarta.persistence.*;

@Entity
@Table
public class Ciutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private int poblacio;
    private String descripcio;
    private String imatge;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    public Ciutat() {
    }

    public Ciutat(String nom, int poblacio, String descripcio, String imatge) {
        this.nom = nom;
        this.poblacio = poblacio;
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

    public int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int poblacio) {
        this.poblacio = poblacio;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}


