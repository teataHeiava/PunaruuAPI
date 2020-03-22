package com.punaruu.igestion.services.transformer;

import com.punaruu.igestion.domain.DTO.DirigeantDTO;
import com.punaruu.igestion.domain.entities.Dirigeant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DirigeantDTOTransformer {

    public DirigeantDTO convertirEnDTO(Dirigeant dirigeant) {
        if (dirigeant == null) {
            return null;
        }

        DirigeantDTO dirigeantDTO = new DirigeantDTO();

        BeanUtils.copyProperties(dirigeant, dirigeantDTO);

        dirigeantDTO.setBureauId(dirigeant.getBureau().getId());
        dirigeantDTO.setSection(dirigeant.getBureau().getSection());

        return dirigeantDTO;
    }
}
