package com.toolsforbiology.repository;


import com.toolsforbiology.model.Primer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */


public interface PrimerRepository extends JpaRepository<Primer,Long> {

    List<Primer> findAllByGene(String gene);

    Primer findByPrimerNameAndOrientation(String primerName, String orientation);

/* Placer dans un service

    public Primer createPrimer(Primer primer) {
        return save(primer);
    }

    @Override
    public PrimerRepository updatePrimer(PrimerRepository primerRepository) {
        return this.primerRepository.save(primerRepository);
    }

   @Override
    public void deletePrimer(Long id) {
        this.primerRepository.delete(id);
    }

    @Override
    public List<PrimerRepository> getPrimersByGene(String gene) {
        return this.primerRepository.findPrimersByGene(gene);
    }

    @Override
    public PrimerRepository getPrimerByPrimerNameAndOrientation(String primerName, String orientation) {
        return this.primerRepository.findPrimerByPrimerNameAndOrientation(primerName,orientation);
    }

    @Override
    public IPrimerRepository getPrimerRepository() {
        return primerRepository;
    }

    @Override
    public void setPrimerRepository(IPrimerRepository primerRepository) {
        this.primerRepository = primerRepository;
    }*/
}
