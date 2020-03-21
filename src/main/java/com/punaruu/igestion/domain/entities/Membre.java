package com.punaruu.igestion.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Membre extends Personne {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "membre")
    Set<Licence> licences;
}
