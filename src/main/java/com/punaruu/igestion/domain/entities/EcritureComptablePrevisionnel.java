package com.punaruu.igestion.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class EcritureComptablePrevisionnel extends AbstractEcritureComptable {

    @ManyToOne
    @JoinColumn(name = "budgetPrevisionnel_id", nullable = false)
    private BudgetPrevisionnel budgetPrevisionnel;
}
