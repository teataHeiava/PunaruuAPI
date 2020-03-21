package com.punaruu.igestion.domain.entities;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entité Commune
 *
 * @author
 * @date ${date}
 */
@Entity
@Data
@Table(indexes = {@Index(unique = true, name = "UNQ_COMMUNE_CODE_POSTAL", columnList = "nom, codePostal")})
public class Commune {
    // @ApiModelProperty(notes="L'identifiant technique de la commune'")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @ApiModelProperty(notes="Le nom de la commune")
    @Column(nullable = false)
    private String nom;

    // @ApiModelProperty(notes="Le code postal de la commune")
    @Column(nullable = false)
    private String codePostal;

    @Version
    private LocalDateTime version;
}

