package com.benjamin.DogRestApi.service;

import com.benjamin.DogRestApi.Entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> AllDogs();

    Dog addDog(Dog dog);


    Dog UpdateDog(Dog dog);

   

   

    Dog getDog(String dogName);

    List<String> getDogBreed();

    Dog getDogByBreed(String breed);

    String deleteDog(Long id);
}
