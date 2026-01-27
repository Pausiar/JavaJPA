package com.pausiar.APIinicial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    @JsonIgnore
    private List<Ciutat> ciutats;

    public Provincia() {
    }

    public Provincia(String nom) {
        this.nom = nom;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Ciutat> getCiutats() {
        return ciutats;
    }

    public void setCiutats(List<Ciutat> ciutats) {
        this.ciutats = ciutats;
    }
}
