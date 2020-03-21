package com.punaruu.igestion.Exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Class d'exception générique pour une exception fonctionnelle projet
 *
 * @author TEATA Heiava
 * @since 04/2018
 */

@Data @EqualsAndHashCode(callSuper = false) public class IgestionException extends RuntimeException {

    ErrorMessage errorMessage;

    public IgestionException(IgestionExceptionEnum iGestionException) {
        this.errorMessage = new ErrorMessage(iGestionException.errorMessage);
    }

    public IgestionException(IgestionExceptionEnum iGestionException, String detail) {
        this.errorMessage = new ErrorMessage(iGestionException.errorMessage, detail);
    }

    public IgestionException(IgestionExceptionEnum iGestionException, List<String> details) {
        StringBuilder stringBuilder = new StringBuilder();
        details.forEach(detail -> stringBuilder.append(detail));
        this.errorMessage = new ErrorMessage(iGestionException.errorMessage, stringBuilder.toString());
    }
}
