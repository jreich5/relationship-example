package com.codeup.pets.repositories;

import com.codeup.pets.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepo extends JpaRepository<Toy, Integer> {
}
