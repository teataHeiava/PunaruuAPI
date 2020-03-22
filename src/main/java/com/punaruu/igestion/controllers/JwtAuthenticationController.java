package com.punaruu.igestion.controllers;

import com.punaruu.igestion.domain.DTO.UtilisateurConnecteDTO;
import com.punaruu.igestion.domain.security.JwtRequest;
import com.punaruu.igestion.domain.security.JwtResponse;
import com.punaruu.igestion.domain.security.UtilisateurConnecte;
import com.punaruu.igestion.services.security.JwtTokenUtilPunaruu;
import com.punaruu.igestion.services.security.JwtUserDetailsService;
import com.punaruu.igestion.services.transformer.DirigeantDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtilPunaruu jwtTokenUtilPunaruu;

    @Autowired
    private DirigeantDTOTransformer dirigeantDTOTransformer;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        final UserDetails userDetails = this.userDetailsService.loadUserByIdentifiantPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final String token = jwtTokenUtilPunaruu.generateToken(userDetails);

        UtilisateurConnecteDTO utilisateurConnecteDTO = new UtilisateurConnecteDTO();

        utilisateurConnecteDTO.setDirigeant(this.dirigeantDTOTransformer.convertirEnDTO(((UtilisateurConnecte) userDetails).getDirigeant()));
        utilisateurConnecteDTO.setToken(token);

        return ResponseEntity.ok(new JwtResponse(utilisateurConnecteDTO));
    }

}