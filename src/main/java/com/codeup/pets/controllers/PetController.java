package com.codeup.pets.controllers;

import com.codeup.pets.models.Pet;
import com.codeup.pets.models.PetDetails;
import com.codeup.pets.repositories.PetRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetController {

    private final PetRepo petDao;

    public PetController(PetRepo petDao) {
        this.petDao = petDao;
    }


    // TESTING ONE TO ONE RELATIONSHIP...

    @GetMapping("/pets")
    public String returnTestView(Model viewModel) {
        viewModel.addAttribute("pet", petDao.getOne(1));
        return "pets/test";
    }

    @PostMapping("/pets/update/{id}")
    public String updatePersonality(@PathVariable int id, @RequestParam String personality) {

        // get the correct pet object to update
        Pet pet = petDao.getOne(id);

        // get the current pet details
        PetDetails pd = pet.getPetDetails();

        // update the pet details with the current details
        pd.setPersonalityDescription(personality);
        pet.setPetDetails(pd);

        // update the database record
        petDao.save(pet);

        return "redirect:/pets";
    }

}
