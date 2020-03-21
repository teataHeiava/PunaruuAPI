package com.punaruu.igestion.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Bureau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateElection;

    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bureau")
    private Set<Dirigeant> dirigeants;

    @Version
    private LocalDateTime version;
}
