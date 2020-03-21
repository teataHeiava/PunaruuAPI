package com.punaruu.igestion.domain.enumerations;

import java.util.ArrayList;
import java.util.List;

public enum TypeEcritureComptableEnum {
    SUBVENTIONPAYS("SUBVENTION PAYS", NatureEcritureComptableEnum.RECETTE),
    SUBVENTIONTERR("SUBVENTION TERRITOIRE", NatureEcritureComptableEnum.RECETTE),
    AUTRESDEP("AUTRES TYPES DEPENSES", NatureEcritureComptableEnum.DEPENSE),
    AUTRESREC("AUTRES TYPES RECETTES", NatureEcritureComptableEnum.RECETTE);

    private String libelle;
    private NatureEcritureComptableEnum natureEcritureComptableEnum;

    TypeEcritureComptableEnum(String libelle, NatureEcritureComptableEnum natureEcritureComptableEnum) {
        libelle = libelle;
        natureEcritureComptableEnum = natureEcritureComptableEnum;
    }

    /**
     * Méthode qui retourne les types d'écriture de nature DEPENSE
     * @return la liste
     */
    public static List<TypeEcritureComptableEnum> listerTypesDepence() {
        List<TypeEcritureComptableEnum> typesDepense = new ArrayList<>();

        for (TypeEcritureComptableEnum typeEcriture: TypeEcritureComptableEnum.values()) {
            if (typeEcriture.natureEcritureComptableEnum == NatureEcritureComptableEnum.DEPENSE) {
                typesDepense.add(typeEcriture);
            }
        }

        return typesDepense;
    }

    /**
     * Méthode qui retourne les types d'écriture de nature RECETTE
     * @return la liste
     */
    public static List<TypeEcritureComptableEnum> listerTypesRecette() {
        List<TypeEcritureComptableEnum> typesRecette = new ArrayList<>();

        for (TypeEcritureComptableEnum typeEcriture: TypeEcritureComptableEnum.values()) {
            if (typeEcriture.natureEcritureComptableEnum == NatureEcritureComptableEnum.RECETTE) {
                typesRecette.add(typeEcriture);
            }
        }

        return typesRecette;
    }
}
