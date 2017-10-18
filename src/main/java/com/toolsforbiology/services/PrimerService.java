package com.toolsforbiology.services;

import com.toolsforbiology.model.Primer;
import com.toolsforbiology.repository.PrimerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pascalbardeau on 06/09/2017.
 */

@Service
public class PrimerService  {

    @Resource
    private PrimerRepository primerRepository;

//    @Override
//    public List<PrimerRepository> getAllPrimers() {
//        return this.primerRepository.findAll();
//    }
//
//    @Override
//    public PrimerRepository getPrimerById(Long id) {
//        return this.primerRepository.findOne(id);
//    }
//

    public Primer createPrimer(Primer primer) {
        return this.primerRepository.save(primer);
    }
//
//    @Override
//    public PrimerRepository updatePrimer(PrimerRepository primerRepository) {
//        return this.primerRepository.save(primerRepository);
//    }
//
//    @Override
//    public void deletePrimer(Long id) {
//        this.primerRepository.delete(id);
//    }
//
//    @Override
//    public List<PrimerRepository> getPrimersByGene(String gene) {
//        return this.primerRepository.findPrimersByGene(gene);
//    }
//
//    @Override
//    public PrimerRepository getPrimerByPrimerNameAndOrientation(String primerName, String orientation) {
//        return this.primerRepository.findPrimerByPrimerNameAndOrientation(primerName,orientation);
//    }
//
//    @Override
//    public IPrimerRepository getPrimerRepository() {
//        return primerRepository;
//    }
//
//    @Override
//    public void setPrimerRepository(IPrimerRepository primerRepository) {
//        this.primerRepository = primerRepository;
//    }

}
