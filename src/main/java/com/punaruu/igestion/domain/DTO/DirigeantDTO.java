package com.punaruu.igestion.domain.DTO;

import com.punaruu.igestion.domain.entities.Commune;
import com.punaruu.igestion.domain.entities.Section;
import com.punaruu.igestion.domain.enumerations.FonctionBureauEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DirigeantDTO {

    private Integer id;

    private String nom;

    private String prenom;

    private String telehoneFixe;

    private String telephonePortable;

    private LocalDate dateNaissance;

    private Commune commune;

    private String adresseGeographique;

    private LocalDateTime version;

    private FonctionBureauEnum fonction;

    private String identifiant;

    private LocalDate dateFin;

    private int bureauId;

    private Section section;
}
