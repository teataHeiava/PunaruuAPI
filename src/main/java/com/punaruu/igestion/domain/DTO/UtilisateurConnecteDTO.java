package com.punaruu.igestion.domain.DTO;

import lombok.Data;

@Data
public class UtilisateurConnecteDTO {

    private DirigeantDTO dirigeant;

    private String token;
}
