package com.punaruu.igestion.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class EcritureComptableBilan extends AbstractEcritureComptable {

    @ManyToOne
    @JoinColumn(name = "bilan_id", nullable = false)
    private Bilan bilan;
}
