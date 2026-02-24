package com.pausiar.APICompleta.models.DTO;

import java.util.List;

public class ModoJuegoEstadistiquesResponse {

    private String nomModo;
    private String descripcio;
    private int numMapes;
    private List<String> nomsMapes;

    public ModoJuegoEstadistiquesResponse() {
    }

    public ModoJuegoEstadistiquesResponse(String nomModo, String descripcio, int numMapes, List<String> nomsMapes) {
        this.nomModo = nomModo;
        this.descripcio = descripcio;
        this.numMapes = numMapes;
        this.nomsMapes = nomsMapes;
    }

    public String getNomModo() {
        return nomModo;
    }

    public void setNomModo(String nomModo) {
        this.nomModo = nomModo;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumMapes() {
        return numMapes;
    }

    public void setNumMapes(int numMapes) {
        this.numMapes = numMapes;
    }

    public List<String> getNomsMapes() {
        return nomsMapes;
    }

    public void setNomsMapes(List<String> nomsMapes) {
        this.nomsMapes = nomsMapes;
    }
}

