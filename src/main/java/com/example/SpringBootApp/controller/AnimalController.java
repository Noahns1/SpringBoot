package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.model.Animal;
import com.example.SpringBootApp.repo.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepo animalRepo;

    @GetMapping("/getAllAnimals")
    public ResponseEntity<List<Animal>> getAllAnimals(){

        try {
            List<Animal> animalList =  new ArrayList<>();
            animalRepo.findAll().forEach(animalList::add);

            if (animalList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animalList, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAnimalById/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id){

        Optional<Animal> animalData = animalRepo.findById(id);

        return animalData.map(animal -> new ResponseEntity<>(animal, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @PostMapping("/addAnimal")
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal){

        Animal animalObj = animalRepo.save(animal);

        return new ResponseEntity<>(animalObj, HttpStatus.OK);

    }

    @PostMapping("/updateAnimalById/{id}")
    public ResponseEntity<Animal> updateAnimalById(@PathVariable Long id, @RequestBody Animal newAnimalData){

        Optional<Animal> oldAnimalData = animalRepo.findById(id);

        if (oldAnimalData.isPresent()) {
            Animal updatedAnimalData = oldAnimalData.get();
            updatedAnimalData.setSpecies(newAnimalData.getSpecies());
            updatedAnimalData.setName(newAnimalData.getName());

            Animal animalObj = animalRepo.save(updatedAnimalData);
            return new ResponseEntity<>(animalObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteAnimalById/{id}")
    public ResponseEntity<Animal> deleteAnimalById(@PathVariable Long id){

        animalRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
