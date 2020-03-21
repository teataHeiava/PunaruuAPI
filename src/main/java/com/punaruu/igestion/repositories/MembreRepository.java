package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository {@link Membre}
 */

public interface MembreRepository extends JpaRepository<Membre, Integer> {
}
