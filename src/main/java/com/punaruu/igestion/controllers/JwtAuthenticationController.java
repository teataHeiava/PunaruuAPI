package com.punaruu.igestion.controllers;

import com.punaruu.igestion.Exceptions.IgestionException;
import com.punaruu.igestion.Exceptions.IgestionExceptionEnum;
import com.punaruu.igestion.domain.DTO.UtilisateurConnecteDTO;
import com.punaruu.igestion.domain.security.UtilisateurConnecte;
import com.punaruu.igestion.services.security.JwtTokenUtilPunaruu;
import com.punaruu.igestion.services.security.JwtUserDetailsService;
import com.punaruu.igestion.services.transformer.DirigeantDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    final static String SEPARATEUR = ":";

    @Autowired
    private JwtTokenUtilPunaruu jwtTokenUtilPunaruu;

    @Autowired
    private DirigeantDTOTransformer dirigeantDTOTransformer;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<UtilisateurConnecteDTO> createAuthenticationToken(@RequestHeader("Authorization") String authorizationEncode) {

        if (!authorizationEncode.contains("Basic ") ) {
            new IgestionException(IgestionExceptionEnum.UNAUTHORIZED);
        }

        String authorizationDecode = new String(Base64.getDecoder().decode(authorizationEncode.substring(6)));

        int indexSeparateur = authorizationDecode.indexOf(SEPARATEUR);

        final UserDetails userDetails = this.userDetailsService.loadUserByIdentifiantPassword(authorizationDecode.substring(0, indexSeparateur), authorizationDecode.substring(indexSeparateur + 1));

        final String token = jwtTokenUtilPunaruu.generateToken(userDetails);

        UtilisateurConnecteDTO utilisateurConnecteDTO = new UtilisateurConnecteDTO();

        utilisateurConnecteDTO.setDirigeant(this.dirigeantDTOTransformer.convertirEnDTO(((UtilisateurConnecte) userDetails).getDirigeant()));
        utilisateurConnecteDTO.setToken(token);

        return new ResponseEntity(utilisateurConnecteDTO, HttpStatus.OK);
    }

}