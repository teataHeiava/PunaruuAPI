package com.punaruu.igestion.domain.DTO;

import com.punaruu.igestion.domain.enumerations.DisciplineEnum;
import com.punaruu.igestion.domain.enumerations.TypeCalendrierEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SectionMajDTO {

    private Integer id;

    private String nom;

    private LocalDate dateValidationCatp;

    private DisciplineEnum discipline;

    private TypeCalendrierEnum typeCalendrier;

    private String code;

    private LocalDateTime version;
}
