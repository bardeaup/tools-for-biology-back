package com.toolsforbiology.services;

import com.toolsforbiology.repository.IPrimerRepository;
import com.toolsforbiology.repository.Primer;

import java.util.Collection;
import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */
public interface IPrimerService {
    Collection<Primer> getAllPrimers();

    Primer getPrimerById(Long id);

    Primer createPrimer(Primer primer);

    Primer updatePrimer(Primer primer);

    void deletePrimer(Long id);

    List<Primer> getPrimersByGene(String gene);

    Primer getPrimerByPrimerNameAndOrientation(String primerName, String orientation);

    IPrimerRepository getPrimerRepository();

    void setPrimerRepository(IPrimerRepository primerRepository);

    // todo : http://sqli.developpez.com/tutoriels/spring/construire-backend-springboot/#LIII-A
}
