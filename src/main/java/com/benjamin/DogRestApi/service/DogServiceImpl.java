package com.benjamin.DogRestApi.service;

import com.benjamin.DogRestApi.Entity.Dog;
import com.benjamin.DogRestApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DogServiceImpl implements DogService{
    @Autowired
    private DogRepository dogRepository;
    @Override
    public List<Dog> AllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Dog UpdateDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public String deleteDog(Integer id) {
        dogRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Dog getDog(String dogName) {
        return dogRepository.findByName(dogName);
    }

    @Override
    public List<String> getDogBreed() {
        return dogRepository.findBreed();
    }

    @Override
    public Dog getDogByBreed(String breed) {
        return dogRepository.findByBreed(breed);
    }


}
