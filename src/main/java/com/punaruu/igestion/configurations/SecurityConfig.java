package com.punaruu.igestion.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Class de configuration de la sécurité des WS
 *
 * @author TEATA Heiava
 * @since 04/2018
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Login de l'utilisateur accédant au WS de paramétrage
    @Value("${spring.security.user.name}")
    private String userParam;

    // Password de l'utilisateur accédant au WS de paramétrage
    @Value("${spring.security.user.password}")
    private String passwordParam;

    /*@Bean
    ApiOriginFilter corsFilter() {
        return new ApiOriginFilter();
    }*/

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("X-Auth-Key", "X-Auth-Secret","Origin", "X-Requested-With", "Content-Type", "Accept",
                "Authorization", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and();
        http.authorizeRequests().anyRequest().fullyAuthenticated();
        http.httpBasic();
        http.csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) {
        //Les anciennes url mis en place par itaieteV1 ne nécéssitant pas de loginn/password, je les exclus du processus d'authentification afin
        // d'assurer une compatibilité avec les autres appli utilisant ces WS
       // web.ignoring().antMatchers("/api/trouverParNumeroTahiti", "/api/trouverParNumeroTahitiNonRadie",
         //       "/api/listerParNumTahitiOuRaisonSocialeLimite", "/api/listerParNumTahitiOuRaisonSociale",
           //     "/api/listerParNumTahitiOuRaisonSocialeNonRadieeLimite", "/api/listerParNumTahitiOuRaisonSocialeNonRadiee",
             //   "/api/listerParListeNumTahiti");
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userParam).password(getPasswordEncoder().encode(passwordParam)).roles("ADMIN");
    }

}
