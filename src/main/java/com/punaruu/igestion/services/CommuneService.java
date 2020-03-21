package com.punaruu.igestion.services;

import com.punaruu.igestion.domain.entities.Commune;
import com.punaruu.igestion.repositories.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service {@link com.punaruu.igestion.domain.entities.Commune}
 */

@Service
public class CommuneService {

    @Autowired
    private CommuneRepository communeRepository;

    /**
     * Liste les communes par critère
     * @param critere le critere
     * @return la liste de commune
     */
    public List<Commune> listerParCritere(String critere) {
        List<Commune> communes = new ArrayList<>();

        if (critere.length() > 2) {
            communes = this.communeRepository.findByNomContainingIgnoreCase(critere);
        }

        return communes;
    }
}
