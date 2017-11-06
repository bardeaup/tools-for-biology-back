package com.toolsforbiology.application.dto;

import lombok.Data;

/**
 * Created by pascalbardeau on 11/10/2017.
 */
@Data
public class PrimerDTO {

    private String gene;
    private String primerName;
    private String orientation;
    private String sequence;

}
