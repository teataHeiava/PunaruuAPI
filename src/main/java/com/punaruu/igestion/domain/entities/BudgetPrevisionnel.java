package com.punaruu.igestion.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Classe définissant un budget prévisionnel
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BudgetPrevisionnel extends AbstractBudgetBilan {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "budgetPrevisionnel")
    List<EcritureComptablePrevisionnel> ecrituresComptablesPrevisionnels;
}
