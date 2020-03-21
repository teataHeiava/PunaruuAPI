package com.punaruu.igestion.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Licence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personne_id", nullable = false)
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @Column(nullable =  false)
    private LocalDate dateAffiliation;

    private boolean certificatMedical;

    private boolean actif;

    @Column(nullable =  false)
    private Integer annee;

    @Version
    private LocalDateTime verion;
}
