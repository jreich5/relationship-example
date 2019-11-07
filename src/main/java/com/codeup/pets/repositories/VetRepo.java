package com.codeup.pets.repositories;

import com.codeup.pets.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepo extends JpaRepository<Vet, Integer> {
}
