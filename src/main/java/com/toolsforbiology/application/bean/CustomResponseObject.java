package com.toolsforbiology.application.bean;

import lombok.Data;

/**
 * Created by pascalbardeau on 06/11/2017.
 */
@Data
public class CustomResponseObject {

    private Object retour;

    private String message;

    private String code;

}
