package com.punaruu.igestion.services.security;

import com.punaruu.igestion.Exceptions.IgestionException;
import com.punaruu.igestion.Exceptions.IgestionExceptionEnum;
import com.punaruu.igestion.domain.entities.Dirigeant;
import com.punaruu.igestion.domain.enumerations.DisciplineEnum;
import com.punaruu.igestion.domain.security.UtilisateurConnecte;
import com.punaruu.igestion.services.DirigeantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private DirigeantService dirigeantService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Dirigeant dirigeant = this.dirigeantService.findByIdentifiant(username);

        if (dirigeant == null) {
            throw new IgestionException(IgestionExceptionEnum.UNAUTHORIZED);
        }

        String listeRoles = "ALL";
        List<GrantedAuthority> autorities = AuthorityUtils.commaSeparatedStringToAuthorityList(listeRoles);

        return new UtilisateurConnecte(dirigeant.getIdentifiant(), "password", autorities, dirigeant);
    }

    public UtilisateurConnecte loadUserByIdentifiantPassword(String identifiant, String password) {
        Dirigeant dirigeant = this.dirigeantService.findByIdentifiantAndPassword(identifiant, password);

        if (dirigeant == null) {
            throw new IgestionException(IgestionExceptionEnum.UNAUTHORIZED);
        }

        String listeRoles = "ALL";
        List<GrantedAuthority> autorities = AuthorityUtils.commaSeparatedStringToAuthorityList(listeRoles);

        return new UtilisateurConnecte(dirigeant.getIdentifiant(), "password", autorities, dirigeant);
    }

    public Dirigeant getUtilisateurConnecte() {
        UtilisateurConnecte utilisateurConnecte = (UtilisateurConnecte) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return utilisateurConnecte.getDirigeant();
    }

    public boolean controleAcces(DisciplineEnum disciplineEnum) {
        Dirigeant dirigeant = this.getUtilisateurConnecte();
        if (dirigeant.getBureau().getSection().getDiscipline() == DisciplineEnum.GRANDBUREAU) {
            return true;
        }

        if (dirigeant.getBureau().getSection().getDiscipline() == disciplineEnum) {
            return true;
        }

        return false;
    }
}