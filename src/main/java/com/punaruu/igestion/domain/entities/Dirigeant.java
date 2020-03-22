package com.punaruu.igestion.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.punaruu.igestion.domain.enumerations.FonctionBureauEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Dirigeant extends Personne {

    @Column(nullable =  false)
    @Enumerated(EnumType.STRING)
    private FonctionBureauEnum fonction;

    @JsonIgnore
    private String identifiant;

    @JsonIgnore
    private String password;

    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "bureau_id", nullable = false)
    private Bureau bureau;
}
