package com.benjamin.DogRestApi.web;

import com.benjamin.DogRestApi.Entity.Dog;
import com.benjamin.DogRestApi.service.DogService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;


    @GetMapping("/allDogs")
    public ResponseEntity<List<Dog>>getAllDogs(){
        List<Dog> dogs=dogService.AllDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @PostMapping("/addDog")
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog){
        return new ResponseEntity<Dog>(dogService.addDog(dog),HttpStatus.OK);
    }

    @PutMapping("/updateDog")
    public ResponseEntity<Dog> updateDog(@RequestBody Dog dog){
        return new ResponseEntity<Dog>(dogService.UpdateDog(dog),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDog/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable Integer id){
        return new ResponseEntity<>(dogService.deleteDog(id),HttpStatus.OK);
    }

    @GetMapping("getDog/{dogName}")
    public ResponseEntity<Dog> getDog(@PathVariable String dogName){
        return new ResponseEntity<Dog>((Dog) dogService.getDog(dogName),HttpStatus.OK);
    }

    @GetMapping("getDogBreed")
    public ResponseEntity<List<String>> getDogBreed(){
        List<String> dogBreed=dogService.getDogBreed();
        return new ResponseEntity<List<String>>(dogBreed,HttpStatus.OK);
    }

    @GetMapping("getDogBreed/{breed}")
    public ResponseEntity<Dog> getDogByBreed(@PathVariable String breed){
        return new ResponseEntity<Dog>(dogService.getDogByBreed(breed),HttpStatus.OK);
    }
}
