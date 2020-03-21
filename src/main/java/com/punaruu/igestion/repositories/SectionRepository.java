package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Section;
import com.punaruu.igestion.domain.enumerations.DisciplineEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository @{@link Section}
 */

public interface SectionRepository extends JpaRepository<Section, Integer> {

    /**
     * Retourne le section par sa discipline
     *
     * @param disciplineEnum la discipline recherchée
     * @return la section
     */
    Section findByDiscipline(@Param("disciline") DisciplineEnum disciplineEnum);

    boolean existsByDiscipline(@Param("disciline") DisciplineEnum disciplineEnum);
}
