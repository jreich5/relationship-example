package com.codeup.pets.models;

import javax.persistence.*;

@Entity
public class PetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private boolean isSterile;

    @Column(columnDefinition = "TEXT")
    private String personalityDescription;

    @Column
    private float weightInOunces;

    @OneToOne(mappedBy = "petDetails")
    private Pet pet;

    public PetDetails() {
    }

    public PetDetails(boolean isSterile, String personalityDescription, float weightInOunces) {
        this.isSterile = isSterile;
        this.personalityDescription = personalityDescription;
        this.weightInOunces = weightInOunces;
    }

    public boolean isSterile() {
        return isSterile;
    }

    public void setSterile(boolean sterile) {
        isSterile = sterile;
    }

    public String getPersonalityDescription() {
        return personalityDescription;
    }

    public void setPersonalityDescription(String personalityDescription) {
        this.personalityDescription = personalityDescription;
    }

    public float getWeightInOunces() {
        return weightInOunces;
    }

    public void setWeightInOunces(float weightInOunces) {
        this.weightInOunces = weightInOunces;
    }
}
