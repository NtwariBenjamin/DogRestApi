package com.benjamin.DogRestApi.web;

import com.benjamin.DogRestApi.Entity.Dog;
import com.benjamin.DogRestApi.service.DogService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request,please follow the API documentation"),
        @ApiResponse(code = 401,message = "Due to Security Constraints, your request can not be Authorized"),
        @ApiResponse(code = 500,message = "Could not Start the server.please make sure the Dog microservice is running")
})
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
    public String deleteDog(@PathVariable Long id){
        dogService.deleteDog(id);
        return "Deleted";
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
