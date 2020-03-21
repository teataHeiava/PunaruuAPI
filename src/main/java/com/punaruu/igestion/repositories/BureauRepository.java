package com.punaruu.igestion.repositories;

import com.punaruu.igestion.domain.entities.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository {@link Bureau}
 */

public interface BureauRepository extends JpaRepository<Bureau, Integer> {
}
