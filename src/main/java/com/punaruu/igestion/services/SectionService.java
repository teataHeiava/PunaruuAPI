package com.punaruu.igestion.services;

import com.punaruu.igestion.Exceptions.IgestionException;
import com.punaruu.igestion.Exceptions.IgestionExceptionEnum;
import com.punaruu.igestion.domain.entities.Section;
import com.punaruu.igestion.domain.enumerations.DisciplineEnum;
import com.punaruu.igestion.domain.enumerations.EnregistrerEnum;
import com.punaruu.igestion.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Service @{@link Section}
 */

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Liste l'ensemble des sections
     * @return la liste des sections
     */
    public List<Section> listerTous() {
        return this.sectionRepository.findAll();
    }

    /**
     * Retourne le section par sa discipline
     *
     * @param disciplineEnum la discipline recherchée
     * @return la section
     */
    public Section trouverParDiscipline(DisciplineEnum disciplineEnum) {
        return this.sectionRepository.findByDiscipline(disciplineEnum);
    }

    /**
     * Méthode d'insertion d'une section
     * @param section la secction a insérer
     * @return la section insérer
     */
    public Section inserer(Section section) {

        this.verifierValeurs(EnregistrerEnum.INSERTION, section);

        if (this.sectionRepository.existsByDiscipline(section.getDiscipline())) {
            throw new IgestionException(IgestionExceptionEnum.ENREGISTREMENT_EXISTANT, section.getDiscipline().toString());
        }

        return this.sectionRepository.save(section);
    }

    /**
     * Méthode de modification d'une section
     * @param section la section à mettre à jour
     * @return la section modifiée
     */
    public Section modifier(Section section) {
        this.verifierValeurs(EnregistrerEnum.MODIFICATION, section);

        Section sectionBase = this.trouverParDiscipline(section.getDiscipline());

        sectionBase.setCode(section.getCode());
        sectionBase.setDateValidationCatp(section.getDateValidationCatp());
        sectionBase.setNom(section.getNom());
        sectionBase.setVersion(section.getVersion());
        sectionBase.setTypeCalendrier(section.getTypeCalendrier());

        return this.sectionRepository.save(sectionBase);
    }

    /**
     * Vérifie les valeurs obligatoiires
     * @param section la section à vérifier
     */
    private void verifierValeurs(EnregistrerEnum enregistrerEnum, Section section) {
        List<String> champs = new ArrayList<>();

        if (enregistrerEnum == EnregistrerEnum.INSERTION &&
                (section.getId() != null || section.getVersion() != null)) {
            throw new IgestionException(IgestionExceptionEnum.INSERT_ID_VERSION);
        } else {
            if (section.getId() == null) {
                champs.add("id");
            }

            if (section.getVersion() == null) {
                champs.add("version");
            }
        }

        if (StringUtils.isEmpty(section.getNom())) {
            champs.add("nom");
        }

        if (section.getDiscipline() == null) {
            champs.add("discipline");
        }

        if (section.getTypeCalendrier() == null) {
            champs.add("type calendrier");
        }

        if (StringUtils.isEmpty(section.getCode())) {
            champs.add("code");
        }

        if (!champs.isEmpty()) {
            throw new IgestionException(IgestionExceptionEnum.VALEUR_OBLIGATOIRE, champs);
        }
    }
}
