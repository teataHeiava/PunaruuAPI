package com.punaruu.igestion.domain.enumerations;

public enum  FonctionBureauEnum {

    PRESIDENT("PRESIDENT"),
    TRESORIER("TRESORIER"),
    SECRETAIRE("SECRETAIRE"),
    VICEPRESIDENT("VICE-PRESIDENT"),
    VICETRESORIER("VICE-TRESORIER"),
    VICESECRETAIRE("VICE-SECRETAIRE");

    private String libelle;

    FonctionBureauEnum(String libelle) {
        this.libelle = libelle;
    }
}
