package com.toolsforbiology.application.repository;

import com.toolsforbiology.application.model.Primer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */

public interface PrimerRepository extends JpaRepository<Primer, Long> {

    List<Primer> findAllByGene(String gene);

    Primer findByPrimerNameAndOrientation(String primerName, String orientation);

}
