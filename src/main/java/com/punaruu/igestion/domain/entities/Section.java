package com.punaruu.igestion.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.punaruu.igestion.domain.enumerations.DisciplineEnum;
import com.punaruu.igestion.domain.enumerations.TypeCalendrierEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Entité definissant une section de punaruu
 */

@Entity
@Data
@Table(indexes = {@Index(unique = true, name = "UNQ_SECTION_DISCIPLINE", columnList = "discipline")})
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    private LocalDate dateValidationCatp;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DisciplineEnum discipline;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeCalendrierEnum typeCalendrier;

    @Column(nullable = false)
    private String code;

    /**
     * Scanne du règlement interieur
     */
    @JsonIgnore
    private byte[] reglementInterieur;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "section")
    @JsonIgnore
    private Set<Bureau> bureaux;

    @Version
    private LocalDateTime version;

    private Bureau bureauActif {
        Bureau bureau = new Bureau();

        this.bureaux.forEach(bureau -> {
            
        });
    }
}
