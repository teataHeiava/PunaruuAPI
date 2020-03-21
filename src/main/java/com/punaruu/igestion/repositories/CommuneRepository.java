package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository @{@link Commune}
 */

public interface CommuneRepository extends JpaRepository<Commune, Integer> {

    List<Commune> findByNomContainingIgnoreCase(@Param("critere") String critere);
}
