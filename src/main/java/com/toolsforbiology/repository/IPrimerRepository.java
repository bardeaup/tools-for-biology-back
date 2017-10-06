package com.toolsforbiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pascalbardeau on 06/09/2017.
 */

@Repository
public interface IPrimerRepository extends JpaRepository<Primer,Long> {
    List<Primer> findPrimersByGene(String gene);
    Primer findPrimerByPrimerNameAndOrientation(String primerName, String orientation);
}
