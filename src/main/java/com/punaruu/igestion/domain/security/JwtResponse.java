package com.punaruu.igestion.domain.security;

import com.punaruu.igestion.domain.DTO.UtilisateurConnecteDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final UtilisateurConnecteDTO utilisateurConnecteDTO;

    public JwtResponse(UtilisateurConnecteDTO utilisateurConnecteDTO) {
        this.utilisateurConnecteDTO = utilisateurConnecteDTO;
    }
}