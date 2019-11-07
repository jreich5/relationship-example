package com.codeup.pets.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 400, nullable = false)
    private String address;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "pet_vet",
//            joinColumns = {@JoinColumn(name="pet_id")},
//            inverseJoinColumns = {@JoinColumn(name="vet_id")}
//    )
//    private List<Pet> pets;

    public Vet() {
    }

    public Vet(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Vet(String name, String address, String phoneNumber, List<Pet> pets) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
//        this.pets = pets;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public List<Pet> getPets() {
//        return pets;
//    }
//
//    public void setPets(List<Pet> pets) {
//        this.pets = pets;
//    }


}
