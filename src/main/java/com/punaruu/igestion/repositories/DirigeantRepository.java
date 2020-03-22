package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Dirigeant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository {@link Dirigeant}
 */

public interface DirigeantRepository extends JpaRepository<Dirigeant,  Integer> {

    Dirigeant findByIdentifiantAndPassword(@Param("identifiant") String identifiant, @Param("password") String password);

    Dirigeant findByIdentifiant(@Param("identifiant") String identifiant);
}
