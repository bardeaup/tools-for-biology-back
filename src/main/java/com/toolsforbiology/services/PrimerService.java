package com.toolsforbiology.services;

import com.toolsforbiology.repository.IPrimerRepository;
import com.toolsforbiology.repository.Primer;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */

@Service
public class PrimerService implements IPrimerService {

    @Resource
    private IPrimerRepository primerRepository;

    @Override
    public List<Primer> getAllPrimers() {
        return this.primerRepository.findAll();
    }

    @Override
    public Primer getPrimerById(Long id) {
        return this.primerRepository.findOne(id);
    }

    @Override
    public Primer createPrimer(Primer primer) {
        return this.primerRepository.save(primer);
    }

    @Override
    public Primer updatePrimer(Primer primer) {
        return this.primerRepository.save(primer);
    }

    @Override
    public void deletePrimer(Long id) {
        this.primerRepository.delete(id);
    }

    @Override
    public List<Primer> getPrimersByGene(String gene) {
        return this.primerRepository.findPrimersByGene(gene);
    }

    @Override
    public Primer getPrimerByPrimerNameAndOrientation(String primerName, String orientation) {
        return this.primerRepository.findPrimerByPrimerNameAndOrientation(primerName,orientation);
    }

    @Override
    public IPrimerRepository getPrimerRepository() {
        return primerRepository;
    }

    @Override
    public void setPrimerRepository(IPrimerRepository primerRepository) {
        this.primerRepository = primerRepository;
    }

}
