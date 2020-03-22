package com.punaruu.igestion.services;

import com.punaruu.igestion.domain.entities.Dirigeant;
import com.punaruu.igestion.repositories.DirigeantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirigeantService {

    @Autowired
    DirigeantRepository dirigeantRepository;

    public Dirigeant findByIdentifiantAndPassword(String identifiant, String password) {
        return this.dirigeantRepository.findByIdentifiantAndPassword(identifiant, password);
    }

    public Dirigeant findByIdentifiant(String identifiant) {
        return this.dirigeantRepository.findByIdentifiant(identifiant);
    }
}
