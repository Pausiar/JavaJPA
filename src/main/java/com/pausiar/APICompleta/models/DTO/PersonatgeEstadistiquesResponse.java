package com.pausiar.APICompleta.models.DTO;

import java.util.List;

public class PersonatgeEstadistiquesResponse {

    private String nomPersonatge;
    private String rol;
    private int numHabilitats;
    private List<String> teclesUtilitzades;
    private String habilitatUltimate;
    private List<String> nomsHabilitats;

    public PersonatgeEstadistiquesResponse() {
    }

    public PersonatgeEstadistiquesResponse(String nomPersonatge, String rol, int numHabilitats,
            List<String> teclesUtilitzades, String habilitatUltimate, List<String> nomsHabilitats) {
        this.nomPersonatge = nomPersonatge;
        this.rol = rol;
        this.numHabilitats = numHabilitats;
        this.teclesUtilitzades = teclesUtilitzades;
        this.habilitatUltimate = habilitatUltimate;
        this.nomsHabilitats = nomsHabilitats;
    }

    public String getNomPersonatge() {
        return nomPersonatge;
    }

    public void setNomPersonatge(String nomPersonatge) {
        this.nomPersonatge = nomPersonatge;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getNumHabilitats() {
        return numHabilitats;
    }

    public void setNumHabilitats(int numHabilitats) {
        this.numHabilitats = numHabilitats;
    }

    public List<String> getTeclesUtilitzades() {
        return teclesUtilitzades;
    }

    public void setTeclesUtilitzades(List<String> teclesUtilitzades) {
        this.teclesUtilitzades = teclesUtilitzades;
    }

    public String getHabilitatUltimate() {
        return habilitatUltimate;
    }

    public void setHabilitatUltimate(String habilitatUltimate) {
        this.habilitatUltimate = habilitatUltimate;
    }

    public List<String> getNomsHabilitats() {
        return nomsHabilitats;
    }

    public void setNomsHabilitats(List<String> nomsHabilitats) {
        this.nomsHabilitats = nomsHabilitats;
    }
}

