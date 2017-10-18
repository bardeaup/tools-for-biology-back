package com.toolsforbiology.services;

import com.toolsforbiology.repository.PrimerRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */
public interface IPrimerService {
    Collection<PrimerRepository> getAllPrimers();

    PrimerRepository getPrimerById(Long id);

    PrimerRepository createPrimer(PrimerRepository primerRepository);

    PrimerRepository updatePrimer(PrimerRepository primerRepository);

    void deletePrimer(Long id);

    List<PrimerRepository> getPrimersByGene(String gene);

    PrimerRepository getPrimerByPrimerNameAndOrientation(String primerName, String orientation);

    PrimerRepository getPrimerRepository();

    void setPrimerRepository(PrimerRepository primerRepository);

    // todo : http://sqli.developpez.com/tutoriels/spring/construire-backend-springboot/#LIII-A
}
