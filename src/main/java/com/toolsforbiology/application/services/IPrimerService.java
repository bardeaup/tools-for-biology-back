package com.toolsforbiology.application.services;

import com.toolsforbiology.application.model.Primer;

/**
 * Created by pascalbardeau on 06/09/2017.
 */
public interface IPrimerService {

    Primer createPrimer(Primer primer);

    Primer updatePrimer(Primer primer);

    void deletePrimer(Long id);
}
