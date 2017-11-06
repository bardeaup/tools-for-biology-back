package com.toolsforbiology.application.model;

import javax.persistence.*;

/**
 * Created by pascalbardeau on 11/10/2017.
 */

@Entity
@Table(name = "primer")
public class Primer {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="gene",nullable = false)
    private String gene;

    @Column(name="primerName",nullable = false)
    private String primerName;

    @Column(name="orientation",nullable = false)
    private String orientation;

    @Column(name="sequence",nullable = false)
    private String sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public String getPrimerName() {
        return primerName;
    }

    public void setPrimerName(String primerName) {
        this.primerName = primerName;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
