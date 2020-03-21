package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Licence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository {@link Licence}
 */

public interface LicenceRepository extends JpaRepository<Licence, Integer> {
}
