package com.punaruu.igestion.Exceptions;

public enum IgestionExceptionEnum {
    //Enumérer ici les exceptions fonctionnelles
    VALEUR_OBLIGATOIRE("Valeur obigatoire attendues"),
    ENREGISTREMENT_EXISTANT("Enregistrement déjà existant"),
    INSERT_ID_VERSION("ID ou Version interdite en insertion"),
    ANOMALIE("Anomalies");

    String errorMessage;

    IgestionExceptionEnum(String message) {
            this.errorMessage = message;
    }
}
