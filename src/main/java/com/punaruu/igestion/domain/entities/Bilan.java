package com.punaruu.igestion.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Class définissant un bilan
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Bilan extends AbstractBudgetBilan{

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bilan")
    private List<EcritureComptableBilan> ecrituresComptablesBilan;
}
