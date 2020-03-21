package com.punaruu.igestion.domain.entities;

import com.punaruu.igestion.domain.enumerations.NatureEcritureComptableEnum;
import com.punaruu.igestion.domain.enumerations.TypeEcritureComptableEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEcritureComptable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private LocalDateTime version;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private Integer montant;

    @Column(nullable = false)
    private NatureEcritureComptableEnum nature;

    @Column(nullable = false)
    private TypeEcritureComptableEnum typeEcritureComptable;

}
