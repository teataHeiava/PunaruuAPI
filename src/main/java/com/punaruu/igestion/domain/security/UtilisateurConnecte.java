package com.punaruu.igestion.domain.security;

import com.punaruu.igestion.domain.entities.Dirigeant;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class UtilisateurConnecte extends User {

    private Dirigeant dirigeant;

    public UtilisateurConnecte(String username, String password, Collection<? extends GrantedAuthority> authorities, Dirigeant dirigeant) {
        super(username, password, authorities);
        this.dirigeant = dirigeant;
    }

    public UtilisateurConnecte(
            String username,
            String password,
            boolean enabled,
            boolean accountNonExpired,
            boolean credentialsNonExpired,
            boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities,
            Dirigeant utilisateur
    ) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.dirigeant = utilisateur;
    }
}