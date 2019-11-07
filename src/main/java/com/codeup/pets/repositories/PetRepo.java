package com.codeup.pets.repositories;

import com.codeup.pets.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Integer> {

}
