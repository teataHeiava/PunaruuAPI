package com.punaruu.igestion.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String telehoneFixe;

    private String telephonePortable;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @ManyToOne(optional = false)
    private Commune commune;

    @Column(nullable = false)
    private String adresseGeographique;

    @Version
    private LocalDateTime version;

}
