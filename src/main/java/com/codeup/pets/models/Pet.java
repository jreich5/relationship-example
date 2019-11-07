package com.codeup.pets.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL DEFAULT 'Unknown'")
    private String species;

    @OneToOne
    private PetDetails petDetails;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Toy> toys;

    @ManyToMany(mappedBy = "pets")
    private List<Vet> vets;

    public Pet() {
    }

    public Pet(String name, LocalDate dob, String species) {
        this.name = name;
        this.dob = dob;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public PetDetails getPetDetails() {
        return petDetails;
    }

    public void setPetDetails(PetDetails petDetails) {
        this.petDetails = petDetails;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public List<Vet> getVets() {
        return vets;
    }

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
}
