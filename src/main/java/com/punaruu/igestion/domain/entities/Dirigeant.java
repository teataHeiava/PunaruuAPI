package com.punaruu.igestion.domain.entities;

import com.punaruu.igestion.domain.enumerations.FonctionBureauEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Dirigeant extends Personne {

    @Column(nullable =  false)
    private FonctionBureauEnum fonction;

    private String identifiant;

    private String password;

    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "bureau_id", nullable = false)
    private Bureau bureau;
}
