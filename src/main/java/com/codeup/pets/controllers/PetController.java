package com.codeup.pets.controllers;

import com.codeup.pets.models.Pet;
import com.codeup.pets.models.PetDetails;
import com.codeup.pets.models.Toy;
import com.codeup.pets.models.Vet;
import com.codeup.pets.repositories.PetRepo;
import com.codeup.pets.repositories.ToyRepo;
import com.codeup.pets.repositories.VetRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class PetController {

    private final PetRepo petDao;
    private final ToyRepo toyDao;
    private final VetRepo vetDao;

    public PetController(PetRepo petDao, ToyRepo toyDao, VetRepo vetDao) {
        this.petDao = petDao;
        this.toyDao = toyDao;
        this.vetDao = vetDao;
    }

    @GetMapping("/pets")
    public String returnTestView(Model viewModel) {
        viewModel.addAttribute("pet", petDao.getOne(1));
        return "pets/test";
    }


    // TESTING ONE TO ONE RELATIONSHIP...

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

    // TESTING ONE TO MANY RELATIONSHIP...
    @PostMapping("/pets/{id}/add-toy")
    public String addToy(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String brand,
            @RequestParam boolean isDestroyed,
            @RequestParam String description) {

        Toy toy = new Toy(name, brand, isDestroyed, description);
        toy.setPet(petDao.getOne(id));
        toyDao.save(toy);

        return "redirect:/pets";
    }


    // TESTING MANY TO MANY RELATIONSHIP...

    @GetMapping("/pet-vets")
    public String getPetVets(Model model) {
        model.addAttribute("pets", petDao.findAll());
        return "pets/test";
    }

    @PostMapping("/vets/pet/{id}")
    public String assignNewVetToPet(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber) {

        Pet p = petDao.getOne(id);

        // create a new vet and associate the vet with a given pet
        vetDao.save(new Vet(name, address, phoneNumber, Arrays.asList(p)));

        return "redirect:/pet-vets";
    }



}
