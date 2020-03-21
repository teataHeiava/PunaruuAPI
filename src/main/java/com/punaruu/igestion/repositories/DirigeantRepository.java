package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Dirigeant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository {@link Dirigeant}
 */

public interface DirigeantRepository extends JpaRepository<Dirigeant,  Integer> {
}
