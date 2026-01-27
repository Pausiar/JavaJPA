package com.pausiar.APIinicial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<Provincia> provincies;

    public Pais() {
    }

    public Pais(String nom) {
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

    public List<Provincia> getProvincies() {
        return provincies;
    }

    public void setProvincies(List<Provincia> provincies) {
        this.provincies = provincies;
    }
}
