package com.punaruu.igestion.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractBudgetBilan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private LocalDateTime version;

    @Column(nullable = false)
    private Integer annee;

    @ManyToOne
    @JoinColumn(name = "bureau_id", nullable = false)
    private Bureau bureau;
}
