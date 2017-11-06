package com.toolsforbiology.application.rest;

import com.toolsforbiology.application.model.Primer;
import com.toolsforbiology.application.services.IPrimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pascalbardeau on 19/08/2017.
 */

@RestController
@RequestMapping("/api/genome-analysis")
public class GenomeAnalysisController {

    @Autowired
    private IPrimerService primerService;

    // ROLE_USER (Authorities) nécessaire pour avoir acces à cette méthode
//    @PreAuthorize(value = "ROLE_USER")
    @RequestMapping("/primer")
    public Primer createPrimer(@RequestBody Primer primer) {
        // Attention, ne pas toucher au repository depuis le controleur => Utiliser une couche DTO intermédiaire
        // lombok :
        //      - Permet de faire le rôle des getter et setters (pas besoin de les écrire)
        //      - Pour ne pas générer deux fois les mêmes élément et ne pas écraser les lignes @EqualsAndHashCode(of="khgh")
        return this.primerService.createPrimer(primer);
    }


}
