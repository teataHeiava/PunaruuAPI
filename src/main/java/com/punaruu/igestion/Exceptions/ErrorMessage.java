package com.punaruu.igestion.Exceptions;

import lombok.Data;

/**
 * Class contenant le message d'erreur à afficher
 *
 * @author TEATA Heiava
 * @since 04/2018
 */

@Data
@SuppressWarnings({ "unused" })
public class ErrorMessage {

    String message;
    String detail;

    public ErrorMessage(String message,String detail) {
        this.message = message;
        this.detail = detail;
    }
    public ErrorMessage(String message) {
        this.message = message;
        this.detail = null;
    }


}
