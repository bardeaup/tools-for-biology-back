package com.toolsforbiology.application.services;

import com.toolsforbiology.application.model.Primer;
import com.toolsforbiology.application.repository.PrimerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pascalbardeau on 06/09/2017.
 */

@Service
public class PrimerService implements IPrimerService {

    @Resource
    private PrimerRepository primerRepository;

    public Primer createPrimer(Primer primer) {
        return this.primerRepository.save(primer);
    }

    public Primer updatePrimer(Primer primer) {
        return this.primerRepository.save(primer);
    }

    public void deletePrimer(Long id) {
        this.primerRepository.delete(id);
    }
}
