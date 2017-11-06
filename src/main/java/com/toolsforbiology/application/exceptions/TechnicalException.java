package com.toolsforbiology.application.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by pascalbardeau on 06/11/2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TechnicalException extends RuntimeException {

    private static final long serialVersionUID = 3757249497388917126L;
    private final String code;
    private final String message;

    public TechnicalException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}

